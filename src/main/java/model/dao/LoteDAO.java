package model.dao;

import java.util.List;
import model.bo.Lote;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class LoteDAO implements InterfaceDAO<Lote> {

    private static LoteDAO instance;
    protected EntityManager entityManager;

    private LoteDAO() {
        entityManager = getEntityManager();
    }

    public static LoteDAO getInstance() {
        if (instance == null) {
            instance = new LoteDAO();
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
    public void create(Lote objeto) {
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
    public List<Lote> retrieve() {
        TypedQuery<Lote> query = entityManager.createQuery("Select l From lote l", Lote.class);
        return query.getResultList();
    }

    @Override
    public Lote retrieve(int pk) {
        return entityManager.find(Lote.class, pk);
    }

    @Override
    public List<Lote> retrieve(String parametro, String atributo) {
        TypedQuery<Lote> query = entityManager.createQuery("Select l From lote l "
                + " Where " + atributo + " like ( % " + parametro + " % )", Lote.class);
        return query.getResultList();
    }

    @Override
    public void update(Lote objeto) {
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
    public void delete(Lote objeto) {
        try {
            Lote lote = entityManager.find(Lote.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(lote);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
