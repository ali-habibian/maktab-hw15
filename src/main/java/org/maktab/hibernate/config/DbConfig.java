package org.maktab.hibernate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConfig {

    private DbConfig() {

    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("BankManagement");
        return entityManagerFactory.createEntityManager();
    }
}
