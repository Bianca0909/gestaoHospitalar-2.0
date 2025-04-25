package model.dao;

import java.util.List;
import model.bo.Enfermeiro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EnfermeiroDAO implements InterfaceDAO<Enfermeiro> {

    private static EnfermeiroDAO instance;
    protected EntityManager entityManager;

    private EnfermeiroDAO() {
        entityManager = getEntityManager();
    }

    public static EnfermeiroDAO getInstance() {
        if (instance == null) {
            instance = new EnfermeiroDAO();
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
    public void create(Enfermeiro objeto) {
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
    public List<Enfermeiro> retrieve() {
        return entityManager.createQuery("FROM " + Enfermeiro.class.getName(), Enfermeiro.class).getResultList();
    }

    @Override
    public Enfermeiro retrieve(int pk) {
        return entityManager.find(Enfermeiro.class, pk);
    }

    @Override
    public List<Enfermeiro> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + Enfermeiro.class.getName() + " WHERE " + atributo + " LIKE :parametro", Enfermeiro.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
    }

    @Override
    public void update(Enfermeiro objeto) {
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
    public void delete(Enfermeiro objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Enfermeiro.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
