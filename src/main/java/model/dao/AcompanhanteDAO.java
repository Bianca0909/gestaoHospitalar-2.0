package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.bo.Acompanhante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcompanhanteDAO implements InterfaceDAO<Acompanhante> {

    private static AcompanhanteDAO instance;
    protected EntityManager entityManager;

    private AcompanhanteDAO() {
        entityManager = getEntityManager();
    }

    public static AcompanhanteDAO getInstance() {
        if (instance == null) {
            instance = new AcompanhanteDAO();
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
    public void create(Acompanhante objeto) {
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
    public List<Acompanhante> retrieve() {
        List<Acompanhante> acompanhantes = new ArrayList<>();
        acompanhantes = entityManager.createQuery("SELECT a FROM acompanhante a", Acompanhante.class).getResultList();
        return acompanhantes;
    }

    @Override
    public Acompanhante retrieve(int pk) {
        return entityManager.find(Acompanhante.class, pk);
    }

    @Override
    public List<Acompanhante> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + Acompanhante.class.getName() + " WHERE " + atributo + " LIKE :parametro", Acompanhante.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
    }

    @Override
    public void update(Acompanhante objeto) {
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
    public void delete(Acompanhante objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Acompanhante.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
