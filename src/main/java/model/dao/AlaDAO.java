package model.dao;

import java.util.List;
import model.bo.Ala;
import javax.persistence.EntityManager;

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
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = ConnectionFactory.getEntityManager();
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
        List<Ala> alas;
        alas = entityManager.createQuery("SELECT a FROM ala a", Ala.class).getResultList();
        return alas;
    }

    @Override
    public Ala retrieve(int pk) {
        return entityManager.find(Ala.class, pk);
    }

    @Override
    public List<Ala> retrieve(String parametro, String atributo) {
        List<Ala> alas;
        alas = entityManager.createQuery("SELECT a FROM ala a WHERE " + atributo + " LIKE :parametro", Ala.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
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
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Ala.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
