package model.dao;

import java.util.List;
import model.bo.Medico;
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
        return entityManager.createQuery("FROM " + Medico.class.getName(), Medico.class).getResultList();
    }

    @Override
    public Medico retrieve(int pk) {
        return entityManager.find(Medico.class, pk);
    }

    @Override
    public List<Medico> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + Medico.class.getName() + " WHERE " + atributo + " LIKE :parametro", Medico.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
