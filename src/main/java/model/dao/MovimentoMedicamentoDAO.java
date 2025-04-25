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
        List<MovimentoMedicamento> movimentoMedicamentos = new ArrayList<>();
        movimentoMedicamentos = entityManager.createQuery("Select mm From movimentomedicamento mm", MovimentoMedicamento.class).getResultList();
        return movimentoMedicamentos;
    }

    @Override
    public MovimentoMedicamento retrieve(int pk) {
        MovimentoMedicamento movimentoMedicamento = entityManager.find(MovimentoMedicamento.class, pk);
        return movimentoMedicamento;
    }

    @Override
    public List<MovimentoMedicamento> retrieve(String parametro, String atributo) {
        List<MovimentoMedicamento> movimentoMedicamentos = new ArrayList<>();
        movimentoMedicamentos = entityManager.createQuery("Select mm From movimentomedicamento mm "
                + " Where " + atributo + " like ( % " + parametro + " %  )", MovimentoMedicamento.class).getResultList();
        return movimentoMedicamentos;
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
            MovimentoMedicamento movimentoMedicamento = entityManager.find(MovimentoMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(movimentoMedicamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
