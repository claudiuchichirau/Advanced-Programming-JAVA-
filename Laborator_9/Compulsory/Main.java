package org.example.compulsory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Interact with the database using the entity manager

        // Interogarea bazei de date pentru a obține toți artiștii
        List<Artist> artists = entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();

        // Afisarea rezultatelor
        for (Artist artist : artists) {
            System.out.println(artist);
        }

        entityManager.close();
        EntityManagerFactorySingleton.closeEntityManagerFactory();


//
//        // Crearea obiectului EntityManagerFactory
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyApplicationPU");
//
//        // Crearea obiectului EntityManager
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        // Interogarea bazei de date pentru a obține toți artiștii
//        List<Artist> artists = entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
//
//        // Afisarea rezultatelor
//        for (Artist artist : artists) {
//            System.out.println(artist);
//        }
//
//        // Inchiderea EntityManager
//        entityManager.close();
//
//        // Inchiderea EntityManagerFactory
//        entityManagerFactory.close();
    }
}
