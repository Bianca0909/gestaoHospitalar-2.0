package model.dao;

import java.util.List;
import model.bo.Internacao;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InternacaoDAO implements InterfaceDAO<Internacao> {

    private static InternacaoDAO instance;
    protected EntityManager entityManager;

    private InternacaoDAO() {
        entityManager = getEntityManager();
    }

    public static InternacaoDAO getInstance() {
        if (instance == null) {
            instance = new InternacaoDAO();
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
    public void create(Internacao objeto) {
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
    public List<Internacao> retrieve() {
        List<Internacao> internacoes = new ArrayList<>();
        internacoes = entityManager.createQuery("Select i From internacao i", Internacao.class).getResultList();
        return internacoes;
    }

    @Override
    public Internacao retrieve(int pk) {
        Internacao internacao = entityManager.find(Internacao.class, pk);
        return internacao;
    }

    @Override
    public List<Internacao> retrieve(String parametro, String atributo) {
        List<Internacao> internacoes = new ArrayList<>();
        internacoes = entityManager.createQuery("Select i From internacao i "
                + " Where " + atributo + " like ( % " + parametro + " % )", Internacao.class).getResultList();
        return internacoes;
    }

    @Override
    public void update(Internacao objeto) {
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
    public void delete(Internacao objeto) {
        try {
            Internacao internacao = entityManager.find(Internacao.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(internacao);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
