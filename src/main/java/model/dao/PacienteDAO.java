package model.dao;

import java.util.List;
import model.bo.Paciente;
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
        return entityManager.createQuery("FROM " + Paciente.class.getName(), Paciente.class).getResultList();
    }

    @Override
    public Paciente retrieve(int pk) {
        return entityManager.find(Paciente.class, pk);
    }

    @Override
    public List<Paciente> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + Paciente.class.getName() + " WHERE " + atributo + " LIKE :parametro", Paciente.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
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
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Paciente.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
