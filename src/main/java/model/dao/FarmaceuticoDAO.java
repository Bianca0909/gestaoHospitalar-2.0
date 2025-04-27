package model.dao;

import java.util.List;
import model.bo.Farmaceutico;
import java.util.ArrayList;
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
        List<Farmaceutico> farmaceuticos = new ArrayList<>();
        farmaceuticos = entityManager.createQuery("Select f From farmaceutico f", Farmaceutico.class).getResultList();
        return farmaceuticos;
    }

    @Override
    public Farmaceutico retrieve(int pk) {
        Farmaceutico farmaceutico = entityManager.find(Farmaceutico.class, pk);
        return farmaceutico;
    }

    @Override
    public List<Farmaceutico> retrieve(String parametro, String atributo) {
        List<Farmaceutico> farmaceuticos = new ArrayList<>();
        farmaceuticos = entityManager.createQuery("Select f From farmaceutico f "
                + " Where " + atributo + " like ( % " + parametro + " % )", Farmaceutico.class).getResultList();
        return farmaceuticos;
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
            Farmaceutico farmaceutico = entityManager.find(Farmaceutico.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(farmaceutico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
