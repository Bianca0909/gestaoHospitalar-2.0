package model.dao;

import java.util.List;
import model.bo.Laboratorio;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LaboratorioDAO implements InterfaceDAO<Laboratorio> {

     private static LaboratorioDAO instance;
    protected EntityManager entityManager;

    private LaboratorioDAO() {
        entityManager = getEntityManager();
    }

    public static LaboratorioDAO getInstance() {
        if (instance == null) {
            instance = new LaboratorioDAO();
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
    public void create(Laboratorio objeto) {
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
    public List<Laboratorio> retrieve() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        laboratorios = entityManager.createQuery("Select lab From laboratorio lab", Laboratorio.class).getResultList();
        return laboratorios;
    }

    @Override
    public Laboratorio retrieve(int pk) {
        Laboratorio laboratorio = entityManager.find(Laboratorio.class, pk);
        return laboratorio;
    }

    @Override
    public List<Laboratorio> retrieve(String parametro, String atributo) {
        List<Laboratorio> laboratorios = new ArrayList<>();
        laboratorios = entityManager.createQuery("Select lab From laboratorio lab "
                + " Where " + atributo + " like ( % " + parametro + " %  )", Laboratorio.class).getResultList();
        return laboratorios;
    }

    @Override
    public void update(Laboratorio objeto) {
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
    public void delete(Laboratorio objeto) {

        try {
            Laboratorio laboratorio = entityManager.find(Laboratorio.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(laboratorio);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

}
