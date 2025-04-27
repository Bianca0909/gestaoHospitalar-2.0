package model.dao;

import java.util.List;
import model.bo.Leito;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class LeitoDAO implements InterfaceDAO<Leito> {

    private static LeitoDAO instance;
    protected EntityManager entityManager;

    private LeitoDAO() {
        entityManager = getEntityManager();
    }

    public static LeitoDAO getInstance() {
        if (instance == null) {
            instance = new LeitoDAO();
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
    public void create(Leito objeto) {
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
    public List<Leito> retrieve() {
        TypedQuery<Leito> query = entityManager.createQuery("Select l From leito l", Leito.class);
        return query.getResultList();
    }

    @Override
    public Leito retrieve(int pk) {
        return entityManager.find(Leito.class, pk);
    }

    @Override
    public List<Leito> retrieve(String parametro, String atributo) {
        TypedQuery<Leito> query = entityManager.createQuery("Select l From leito l "
                + " Where " + atributo + " like ( % " + parametro + " % )", Leito.class);
        return query.getResultList();
    }

    @Override
    public void update(Leito objeto) {
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
    public void delete(Leito objeto) {
        try {
            Leito leito = entityManager.find(Leito.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(leito);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
