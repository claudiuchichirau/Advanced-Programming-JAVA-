package org.example.compulsory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if(entityManagerFactory == null) {
            synchronized (EntityManagerFactorySingleton.class) {
                if(entityManagerFactory == null) {
                    new EntityManagerFactorySingleton();
                }
            }
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
