package model.dao;

import java.util.List;
import model.bo.Prontuario;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProntuarioDAO implements InterfaceDAO<Prontuario> {

    private static ProntuarioDAO instance;
    protected EntityManager entityManager;

    private ProntuarioDAO() {
        entityManager = getEntityManager();
    }

    public static ProntuarioDAO getInstance() {
        if (instance == null) {
            instance = new ProntuarioDAO();
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
    public void create(Prontuario objeto) {
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
    public List<Prontuario> retrieve() {
        List<Prontuario> prontuarios = new ArrayList<>();
        prontuarios = entityManager.createQuery("Select p From prontuario p", Prontuario.class).getResultList();
        return prontuarios;
    }

    @Override
    public Prontuario retrieve(int pk) {
        Prontuario prontuario = entityManager.find(Prontuario.class, pk);
        return prontuario;
    }

    @Override
    public List<Prontuario> retrieve(String parametro, String atributo) {
        List<Prontuario> prontuarios = new ArrayList<>();
        prontuarios = entityManager.createQuery("Select p From prontuario p "
                + " Where " + atributo + " like ( % " + parametro + " % )", Prontuario.class).getResultList();
        return prontuarios;
    }

    @Override
    public void update(Prontuario objeto) {
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
    public void delete(Prontuario objeto) {
        try {
            Prontuario prontuario = entityManager.find(Prontuario.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(prontuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
