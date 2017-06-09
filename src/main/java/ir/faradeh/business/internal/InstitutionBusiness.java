/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.business.internal;

import ir.faradeh.dao.impl.InstitutionDao;
import ir.faradeh.exception.ExistInstitutionNameException;
import ir.faradeh.exception.FailedCreateInstitutionException;
import ir.faradeh.exception.FailedDeleteInstitutionException;
import ir.faradeh.exception.FailedEditInstitutionException;
import ir.faradeh.model.entity.InstitutionEntity;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author Mohammad
 */
@Stateless
public class InstitutionBusiness {

    public InstitutionEntity getById(String id) {
        HashMap<String, Object> param = new HashMap<>();
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);

        param.put("_id", new ObjectId(id));
        return institutionDao.find(param);
    }

    public InstitutionEntity getByName(String name) {
        HashMap<String, Object> param = new HashMap<>();
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);

        param.put("InstitutionName", name);
        return institutionDao.find(param);
    }

    public InstitutionEntity add(InstitutionEntity entity) throws ExistInstitutionNameException, FailedCreateInstitutionException {
        if (getByName(entity.getInstitutionName()) != null) {
            throw new ExistInstitutionNameException();
        }
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);
        entity.setCreateDate(new Date());
        InstitutionEntity institutionEntity;
        if ((institutionEntity = institutionDao.insert(entity)) != null) {
            return institutionEntity;
        } else {
            throw new FailedCreateInstitutionException();
        }

    }

    public List<InstitutionEntity> findAll() {
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);
        return institutionDao.findList(null);
    }

    public InstitutionEntity editInstitution(String id, HashMap<String, Object> param) throws FailedEditInstitutionException {
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);
        InstitutionEntity entity;
        if ((entity = institutionDao.merge(new ObjectId(id), param)) != null) {
            return entity;
        } else {
            throw new FailedEditInstitutionException();
        }
    }

    public boolean deleteInstitution(String id) throws FailedDeleteInstitutionException {
        InstitutionDao institutionDao = new InstitutionDao(InstitutionEntity.class);

        if (institutionDao.delete(new ObjectId(id))) {
            return true;
        } else {
            throw new FailedDeleteInstitutionException();
        }
    }
}
