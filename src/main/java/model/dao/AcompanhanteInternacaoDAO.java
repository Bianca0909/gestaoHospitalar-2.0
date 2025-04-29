package model.dao;

import java.util.List;
import model.bo.AcompanhanteInternacao;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcompanhanteInternacaoDAO implements InterfaceDAO<AcompanhanteInternacao> {

    private static AcompanhanteInternacaoDAO instance;
    protected EntityManager entityManager;

    private AcompanhanteInternacaoDAO() {
        entityManager = getEntityManager();
    }

    public static AcompanhanteInternacaoDAO getInstance() {
        if (instance == null) {
            instance = new AcompanhanteInternacaoDAO();
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
    public void create(AcompanhanteInternacao objeto) {
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
    public List<AcompanhanteInternacao> retrieve() {
        return entityManager.createQuery("FROM " + AcompanhanteInternacao.class.getName(), AcompanhanteInternacao.class)
                .getResultList();
    }

    @Override
    public AcompanhanteInternacao retrieve(int pk) {
        return entityManager.find(AcompanhanteInternacao.class, pk);
    }

    @Override
    public List<AcompanhanteInternacao> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + AcompanhanteInternacao.class.getName() + " WHERE " + atributo + " LIKE :parametro", AcompanhanteInternacao.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
    }

    @Override
    public void update(AcompanhanteInternacao objeto) {
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
    public void delete(AcompanhanteInternacao objeto) {
        try {
            AcompanhanteInternacao acompanhanteInternacao = entityManager.find(AcompanhanteInternacao.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(acompanhanteInternacao);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
