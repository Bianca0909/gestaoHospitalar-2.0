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
        List<LaboratorioMedicamento> laboratorios = new ArrayList<>();
        laboratorios = entityManager.createQuery("Select l From laboratorio_medicamento l", LaboratorioMedicamento.class).getResultList();
        return laboratorios;
    }

    @Override
    public LaboratorioMedicamento retrieve(int pk) {
        LaboratorioMedicamento laboratorio = entityManager.find(LaboratorioMedicamento.class, pk);
        return laboratorio;
    }

    @Override
    public List<LaboratorioMedicamento> retrieve(String parametro, String atributo) {
        List<LaboratorioMedicamento> laboratorios = new ArrayList<>();
        laboratorios = entityManager.createQuery("Select l From laboratorio_medicamento l "
                + " Where " + atributo + " like ( % " + parametro + " % )", LaboratorioMedicamento.class).getResultList();
        return laboratorios;
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
            LaboratorioMedicamento laboratorio = entityManager.find(LaboratorioMedicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(laboratorio);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
