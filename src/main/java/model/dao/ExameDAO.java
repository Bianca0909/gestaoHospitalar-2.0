package model.dao;

import java.util.List;
import model.bo.Exame;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        List<Exame> exames = new ArrayList<>();
        exames = entityManager.createQuery("Select e From exame e", Exame.class).getResultList();
        return exames;
    }

    @Override
    public Exame retrieve(int pk) {
        Exame exame = entityManager.find(Exame.class, pk);
        return exame;
    }

    @Override
    public List<Exame> retrieve(String parametro, String atributo) {
        List<Exame> exames = new ArrayList<>();
        exames = entityManager.createQuery("Select e From exame e "
                + " Where " + atributo + " like ( % " + parametro + " %  )", Exame.class).getResultList();
        return exames;
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
