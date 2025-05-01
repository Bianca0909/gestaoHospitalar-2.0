package model.dao;

import java.util.List;
import model.bo.Medico;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MedicoDAO implements InterfaceDAO<Medico> {

    private static MedicoDAO instance;
    protected EntityManager entityManager;

    private MedicoDAO() {
        entityManager = getEntityManager();
    }

    public static MedicoDAO getInstance() {
        if (instance == null) {
            instance = new MedicoDAO();
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
    public void create(Medico objeto) {
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
    public List<Medico> retrieve() {
        List<Medico> medicos = new ArrayList<>();
        medicos = entityManager.createQuery("Select m From medico m", Medico.class).getResultList();
        return medicos;
    }

    @Override
    public Medico retrieve(int pk) {
        Medico medico = entityManager.find(Medico.class, pk);
        return medico;
    }

    @Override
    public List<Medico> retrieve(String parametro, String atributo) {
        List<Medico> medicos = new ArrayList<>();
        medicos = entityManager.createQuery("Select m From medico m "
                + " Where " + atributo + " like ( % " + parametro + " % )", Medico.class).getResultList();
        return medicos;
    }

    @Override
    public void update(Medico objeto) {
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
    public void delete(Medico objeto) {
        try {
            Medico medico = entityManager.find(Medico.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(medico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(int id) {
        try {
            entityManager.getTransaction().begin();
            Medico medico = retrieve(id);
            if (medico != null) {
                entityManager.remove(medico);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
