/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.dao;

import com.mongodb.MongoClient;
import ir.faradeh.utility.Keyword;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author sorena
 */
public class MongoConnection {

    private static MongoClient mongoClient = null;
    private static Datastore mainDatastore = null;

    private MongoConnection() {
    }

    public static Datastore getMainDatastore() {

        if (mainDatastore == null) {
            Morphia morphia = new Morphia();

            //set entity package
            morphia.mapPackage("ir.faradeh.model.entity");
            mainDatastore = morphia.createDatastore(getMongoConnection(), Keyword.MAIN_DB_NAME);
        }

        return mainDatastore;
    }

    private static MongoClient getMongoConnection() {

        if (mongoClient == null) {
            mongoClient = new MongoClient(Keyword.MONGO_IP, Keyword.MONGO_PORT);
        }

        return mongoClient;

    }

}
