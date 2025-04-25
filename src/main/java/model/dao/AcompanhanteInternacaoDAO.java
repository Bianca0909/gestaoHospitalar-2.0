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
        List<AcompanhanteInternacao> acompanhantesInternacao = new ArrayList<>();
        acompanhantesInternacao = entityManager.createQuery("Select ai From acompanhanteinternacao ai", AcompanhanteInternacao.class).getResultList();
        return acompanhantesInternacao;
    }

    @Override
    public AcompanhanteInternacao retrieve(int pk) {
        AcompanhanteInternacao acompanhanteInternacao = entityManager.find(AcompanhanteInternacao.class, pk);
        return acompanhanteInternacao;
    }

    @Override
    public List<AcompanhanteInternacao> retrieve(String parametro, String atributo) {
        List<AcompanhanteInternacao> acompanhantesInternacao = new ArrayList<>();
        acompanhantesInternacao = entityManager.createQuery("Select ai From acompanhanteinternacao ai "
                + " Where " + atributo + " like ( % " + parametro + " %  )", AcompanhanteInternacao.class).getResultList();
        return acompanhantesInternacao;
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
