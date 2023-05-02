package org.example.compulsory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {

    private final EntityManager entityManager;

    public ArtistRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public Artist findById(Long id) {
        return entityManager.find(Artist.class, id);
    }

    public List<Artist> findByName(String namePattern) {
        TypedQuery<Artist> query = entityManager.createQuery(
                "SELECT a FROM artists a WHERE a.name LIKE :namePattern", Artist.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }
}
