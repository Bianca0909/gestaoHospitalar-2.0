package model.dao;

import java.util.List;
import model.bo.ReceitaMedicamento;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceitaMedicamentoDAO implements InterfaceDAO<ReceitaMedicamento> {

    private static ReceitaMedicamentoDAO instance;
    protected EntityManager entityManager;

    private ReceitaMedicamentoDAO() {
        entityManager = getEntityManager();
    }

    public static ReceitaMedicamentoDAO getInstance() {
        if (instance == null) {
            instance = new ReceitaMedicamentoDAO();
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
    public void create(ReceitaMedicamento objeto) {
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
    public List<ReceitaMedicamento> retrieve() {
        List<ReceitaMedicamento> receitaMedicamentos = new ArrayList<>();
        receitaMedicamentos = entityManager.createQuery("Select rm From receitamedicamento rm", ReceitaMedicamento.class).getResultList();
        return receitaMedicamentos;
    }

    @Override
    public ReceitaMedicamento retrieve(int pk) {
        ReceitaMedicamento receitaMedicamento = entityManager.find(ReceitaMedicamento.class, pk);
        return receitaMedicamento;
    }

    @Override
    public List<ReceitaMedicamento> retrieve(String parametro, String atributo) {
        List<ReceitaMedicamento> receitaMedicamentos = new ArrayList<>();
        receitaMedicamentos = entityManager.createQuery("Select rm From receitamedicamento rm "
                + " Where " + atributo + " like ( % " + parametro + " %  )", ReceitaMedicamento.class).getResultList();
        return receitaMedicamentos;
    }

    @Override
    public void update(ReceitaMedicamento objeto) {
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
    public void delete(ReceitaMedicamento objeto) {
        try {
            ReceitaMedicamento receitaMedicamento = entityManager.find(ReceitaMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(receitaMedicamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
