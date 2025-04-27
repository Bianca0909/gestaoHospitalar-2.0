package model.dao;

import java.util.List;
import model.bo.Quarto;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.dao.ConnectionFactory;

public class QuartoDAO implements InterfaceDAO<Quarto> {

    private static QuartoDAO instance;
    protected EntityManager entityManager;

    private QuartoDAO() {
        entityManager = getEntityManager();
    }

    public static QuartoDAO getInstance() {
        if (instance == null) {
            instance = new QuartoDAO();
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
    public void create(Quarto objeto) {
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
    public List<Quarto> retrieve() {
        TypedQuery<Quarto> query = entityManager.createQuery("SELECT q FROM quarto q", Quarto.class);
        return query.getResultList();
    }

    @Override
    public Quarto retrieve(int pk) {
        return entityManager.find(Quarto.class, pk);
    }

    @Override
    public List<Quarto> retrieve(String parametro, String atributo) {
        TypedQuery<Quarto> query = entityManager.createQuery("SELECT q FROM quarto q WHERE " + atributo + " LIKE :parametro", Quarto.class)
                .setParameter("parametro", "%" + parametro + "%");
        return query.getResultList();
    }

    @Override
    public void update(Quarto objeto) {
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
    public void delete(Quarto objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Quarto.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
