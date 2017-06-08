/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.dao;

import com.mongodb.WriteResult;
import java.util.HashMap;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 *
 * @author sorena
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;
    private Datastore datastore = null;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.datastore = MongoConnection.getMainDatastore();
    }

    public T insert(T entity) {
        try {
            Query<T> query = datastore.createQuery(entityClass);
            Key<T> t = datastore.save(entity);
            ObjectId id = (ObjectId) t.getId();
            query.filter("_id =", id);

            return query.get();

        } catch (Exception e) {
            return null;
        }
    }

    public T merge(ObjectId id, HashMap<String, Object> parameters, HashMap<String, Object> filter) throws Exception {
        try {
            Query<T> query = datastore.createQuery(entityClass)
                    .filter("_id =", id);
            if (filter != null) {
                for (String key : filter.keySet()) {
                    query.filter(key + " =", filter.get(key));
                }
            }
            UpdateOperations<T> update = datastore.createUpdateOperations(entityClass);
            for (String key : parameters.keySet()) {
                update.set(key, parameters.get(key));
            }
            UpdateResults res = datastore.update(query, update);
            if (res.getUpdatedExisting()) {
                return query.filter("_id =", id)
                        .get();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public T merge(ObjectId id, HashMap<String, Object> parameters) {
        try {
            Query<T> query = datastore.createQuery(entityClass)
                    .filter("_id =", id);
            UpdateOperations<T> update = datastore.createUpdateOperations(entityClass);
            for (String key : parameters.keySet()) {
                update.set(key, parameters.get(key));
            }
            UpdateResults res = datastore.update(query, update);
            if (res.getUpdatedExisting()) {
                return query.filter("_id =", id)
                        .get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean delete(ObjectId id) {
        try {
            Query<T> query = datastore.createQuery(entityClass)
                    .filter("_id =", id);
            WriteResult result = datastore.delete(query);
            return (result.getN() != 0);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(ObjectId id, HashMap<String, Object> param) {
        try {
            Query<T> query = datastore.createQuery(entityClass)
                    .filter("_id =", id);
            if (param != null) {
                for (String key : param.keySet()) {
                    query.filter(key + " =", param.get(key));
                }
            }
            WriteResult result = datastore.delete(query);
            return (result.getN() != 0);
        } catch (Exception e) {
            return false;
        }
    }

    public List<T> findList(HashMap<String, Object> parameters) {
        Query<T> query = datastore.createQuery(entityClass);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.filter(key + " =", parameters.get(key));
            }
        }
        return (query.asList() != null) ? query.asList() : null;
    }

    public T find(HashMap<String, Object> parameters) {
        Query<T> query = datastore.createQuery(entityClass).disableValidation();
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.filter(key + " =", parameters.get(key));
            }
        }
        return (query.get() != null) ? query.get() : null;
    }

}
