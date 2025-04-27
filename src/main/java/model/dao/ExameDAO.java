package model.dao;

import java.util.List;
import model.bo.Exame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ExameDAO implements InterfaceDAO<Exame> {

    private static ExameDAO instance;
    protected EntityManager entityManager;

    private ExameDAO() {
        entityManager = getEntityManager();
    }

    public static ExameDAO getInstance() {
        if (instance == null) {
            instance = new ExameDAO();
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
    public void create(Exame objeto) {
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
    public List<Exame> retrieve() {
        TypedQuery<Exame> query = entityManager.createQuery("Select e From exame e", Exame.class);
        return query.getResultList();
    }

    @Override
    public Exame retrieve(int pk) {
        return entityManager.find(Exame.class, pk);
    }

    @Override
    public List<Exame> retrieve(String parametro, String atributo) {
        TypedQuery<Exame> query = entityManager.createQuery("Select e From exame e "
                + " Where " + atributo + " like ( % " + parametro + " % )", Exame.class);
        return query.getResultList();
    }

    @Override
    public void update(Exame objeto) {
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
    public void delete(Exame objeto) {
        try {
            Exame exame = entityManager.find(Exame.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(exame);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
