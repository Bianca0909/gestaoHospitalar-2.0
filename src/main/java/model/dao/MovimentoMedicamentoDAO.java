package model.dao;

import java.util.List;
import model.bo.MovimentoMedicamento;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovimentoMedicamentoDAO implements InterfaceDAO<MovimentoMedicamento> {

    private static MovimentoMedicamentoDAO instance;
    protected EntityManager entityManager;

    private MovimentoMedicamentoDAO() {
        entityManager = getEntityManager();
    }

    public static MovimentoMedicamentoDAO getInstance() {
        if (instance == null) {
            instance = new MovimentoMedicamentoDAO();
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
    public void create(MovimentoMedicamento objeto) {
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
    public List<MovimentoMedicamento> retrieve() {
        List<MovimentoMedicamento> movimentos = new ArrayList<>();
        movimentos = entityManager.createQuery("Select m From movimento_medicamento m", MovimentoMedicamento.class).getResultList();
        return movimentos;
    }

    @Override
    public MovimentoMedicamento retrieve(int pk) {
        MovimentoMedicamento movimento = entityManager.find(MovimentoMedicamento.class, pk);
        return movimento;
    }

    @Override
    public List<MovimentoMedicamento> retrieve(String parametro, String atributo) {
        List<MovimentoMedicamento> movimentos = new ArrayList<>();
        movimentos = entityManager.createQuery("Select m From movimento_medicamento m "
                + " Where " + atributo + " like ( % " + parametro + " % )", MovimentoMedicamento.class).getResultList();
        return movimentos;
    }

    @Override
    public void update(MovimentoMedicamento objeto) {
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
    public void delete(MovimentoMedicamento objeto) {
        try {
            MovimentoMedicamento movimento = entityManager.find(MovimentoMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(movimento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
