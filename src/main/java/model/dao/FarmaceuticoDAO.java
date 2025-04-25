package model.dao;

import java.util.List;
import model.bo.Farmaceutico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FarmaceuticoDAO implements InterfaceDAO<Farmaceutico> {

    private static FarmaceuticoDAO instance;
    protected EntityManager entityManager;

    private FarmaceuticoDAO() {
        entityManager = getEntityManager();
    }

    public static FarmaceuticoDAO getInstance() {
        if (instance == null) {
            instance = new FarmaceuticoDAO();
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
    public void create(Farmaceutico objeto) {
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
    public List<Farmaceutico> retrieve() {
        return entityManager.createQuery("FROM " + Farmaceutico.class.getName(), Farmaceutico.class).getResultList();
    }

    @Override
    public Farmaceutico retrieve(int pk) {
        return entityManager.find(Farmaceutico.class, pk);
    }

    @Override
    public List<Farmaceutico> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + Farmaceutico.class.getName() + " WHERE " + atributo + " LIKE :parametro", Farmaceutico.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
    }

    @Override
    public void update(Farmaceutico objeto) {
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
    public void delete(Farmaceutico objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Farmaceutico.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
