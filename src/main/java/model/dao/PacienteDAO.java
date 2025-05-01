package model.dao;

import java.util.List;
import model.bo.Paciente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PacienteDAO implements InterfaceDAO<Paciente> {

    private static PacienteDAO instance;
    protected EntityManager entityManager;

    private PacienteDAO() {
        entityManager = getEntityManager();
    }

    public static PacienteDAO getInstance() {
        if (instance == null) {
            instance = new PacienteDAO();
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
    public void create(Paciente objeto) {
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
    public List<Paciente> retrieve() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes = entityManager.createQuery("SELECT p FROM paciente p", Paciente.class).getResultList();
        return pacientes;
    }

    @Override
    public Paciente retrieve(int pk) {
        Paciente paciente = entityManager.find(Paciente.class, pk);
        return paciente;
    }

    @Override
    public List<Paciente> retrieve(String parametro, String atributo) {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes = entityManager.createQuery("SELECT p FROM paciente p "
                + " Where " + atributo + " like ( % " + parametro + " % )", Paciente.class).getResultList();
        return pacientes;
    }

    @Override
    public void update(Paciente objeto) {
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
    public void delete(Paciente objeto) {
        try {
            Paciente paciente = entityManager.find(Paciente.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(paciente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
