package model.dao;

import java.util.List;
import model.bo.Laboratorio;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = ConnectionFactory.getEntityManager();
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
        TypedQuery<Laboratorio> query = entityManager.createQuery("SELECT l FROM hospital.laboratorio l", Laboratorio.class);
        return query.getResultList();
    }

    @Override
    public Laboratorio retrieve(int pk) {
        return entityManager.find(Laboratorio.class, pk);
    }

    @Override
    public List<Laboratorio> retrieve(String parametro, String atributo) {
        TypedQuery<Laboratorio> query = entityManager.createQuery("SELECT l FROM laboratorio l WHERE " + atributo + " LIKE :parametro", Laboratorio.class)
                .setParameter("parametro", "%" + parametro + "%");
        return query.getResultList();
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
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Laboratorio.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
