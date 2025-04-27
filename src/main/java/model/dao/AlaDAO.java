package model.dao;

import java.util.List;
import model.bo.Ala;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlaDAO implements InterfaceDAO<Ala> {

    private static AlaDAO instance;
    protected EntityManager entityManager;

    private AlaDAO() {
        entityManager = getEntityManager();
    }

    public static AlaDAO getInstance() {
        if (instance == null) {
            instance = new AlaDAO();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    @Override
    public void create(Ala objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Ala> retrieve() {
        List<Ala> alas = new ArrayList<>();
        alas = entityManager.createQuery("Select a From ala a", Ala.class).getResultList();
        return alas;
    }

    @Override
    public Ala retrieve(int pk) {
        Ala ala = entityManager.find(Ala.class, pk);
        return ala;
    }

    @Override
    public List<Ala> retrieve(String parametro, String atributo) {
        List<Ala> alas = new ArrayList<>();
        alas = entityManager.createQuery("Select a From ala a "
                + " Where " + atributo + " like ( % " + parametro + " % )", Ala.class).getResultList();
        return alas;
    }

    @Override
    public void update(Ala objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Ala objeto) {
        try {
            Ala ala = entityManager.find(Ala.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(ala);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
