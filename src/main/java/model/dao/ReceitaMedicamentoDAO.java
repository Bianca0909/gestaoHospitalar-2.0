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
        List<ReceitaMedicamento> receitas = new ArrayList<>();
        receitas = entityManager.createQuery("Select r From receita_medicamento r", ReceitaMedicamento.class).getResultList();
        return receitas;
    }

    @Override
    public ReceitaMedicamento retrieve(int pk) {
        ReceitaMedicamento receita = entityManager.find(ReceitaMedicamento.class, pk);
        return receita;
    }

    @Override
    public List<ReceitaMedicamento> retrieve(String parametro, String atributo) {
        List<ReceitaMedicamento> receitas = new ArrayList<>();
        receitas = entityManager.createQuery("Select r From receita_medicamento r "
                + " Where " + atributo + " like ( % " + parametro + " % )", ReceitaMedicamento.class).getResultList();
        return receitas;
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
            ReceitaMedicamento receita = entityManager.find(ReceitaMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(receita);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
