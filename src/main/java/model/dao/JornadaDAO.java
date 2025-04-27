package model.dao;

import java.util.List;
import model.bo.Jornada;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JornadaDAO implements InterfaceDAO<Jornada> {

    private static JornadaDAO instance;
    protected EntityManager entityManager;

    private JornadaDAO() {
        entityManager = getEntityManager();
    }

    public static JornadaDAO getInstance() {
        if (instance == null) {
            instance = new JornadaDAO();
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
    public void create(Jornada objeto) {
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
    public List<Jornada> retrieve() {
        TypedQuery<Jornada> query = entityManager.createQuery("Select j From Jornada j", Jornada.class);
        return query.getResultList();
    }

    @Override
    public Jornada retrieve(int pk) {
        return entityManager.find(Jornada.class, pk);
    }

    @Override
    public List<Jornada> retrieve(String parametro, String atributo) {
        TypedQuery<Jornada> query = entityManager.createQuery("Select j From Jornada j "
                + " Where " + atributo + " like ( % " + parametro + " % )", Jornada.class);
        return query.getResultList();
    }

    @Override
    public void update(Jornada objeto) {
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
    public void delete(Jornada objeto) {
        try {
            Jornada jornada = entityManager.find(Jornada.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(jornada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
