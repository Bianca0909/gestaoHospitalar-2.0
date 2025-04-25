package model.dao;

import java.util.List;
import model.bo.LaboratorioMedicamento;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LaboratorioMedicamentoDAO implements InterfaceDAO<LaboratorioMedicamento> {

    private static LaboratorioMedicamentoDAO instance;
    protected EntityManager entityManager;

    private LaboratorioMedicamentoDAO() {
        entityManager = getEntityManager();
    }

    public static LaboratorioMedicamentoDAO getInstance() {
        if (instance == null) {
            instance = new LaboratorioMedicamentoDAO();
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
    public void create(LaboratorioMedicamento objeto) {
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
    public List<LaboratorioMedicamento> retrieve() {
        List<LaboratorioMedicamento> laboratorioMedicamentos = new ArrayList<>();
        laboratorioMedicamentos = entityManager.createQuery("Select lm From laboratoriomedicamento lm", LaboratorioMedicamento.class).getResultList();
        return laboratorioMedicamentos;
    }

    @Override
    public LaboratorioMedicamento retrieve(int pk) {
        LaboratorioMedicamento laboratorioMedicamento = entityManager.find(LaboratorioMedicamento.class, pk);
        return laboratorioMedicamento;
    }

    @Override
    public List<LaboratorioMedicamento> retrieve(String parametro, String atributo) {
        List<LaboratorioMedicamento> laboratorioMedicamentos = new ArrayList<>();
        laboratorioMedicamentos = entityManager.createQuery("Select lm From laboratoriomedicamento lm "
                + " Where " + atributo + " like ( % " + parametro + " %  )", LaboratorioMedicamento.class).getResultList();
        return laboratorioMedicamentos;
    }

    @Override
    public void update(LaboratorioMedicamento objeto) {
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
    public void delete(LaboratorioMedicamento objeto) {
        try {
            LaboratorioMedicamento laboratorioMedicamento = entityManager.find(LaboratorioMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(laboratorioMedicamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
