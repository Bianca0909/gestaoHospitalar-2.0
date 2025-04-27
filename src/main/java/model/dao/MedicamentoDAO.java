package model.dao;

import java.util.List;
import model.bo.Medicamento;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MedicamentoDAO implements InterfaceDAO<Medicamento> {

    private static MedicamentoDAO instance;
    protected EntityManager entityManager;

    private MedicamentoDAO() {
        entityManager = getEntityManager();
    }

    public static MedicamentoDAO getInstance() {
        if (instance == null) {
            instance = new MedicamentoDAO();
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
    public void create(Medicamento objeto) {
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
    public List<Medicamento> retrieve() {
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = entityManager.createQuery("Select m From medicamento m", Medicamento.class).getResultList();
        return medicamentos;
    }

    @Override
    public Medicamento retrieve(int pk) {
        Medicamento medicamento = entityManager.find(Medicamento.class, pk);
        return medicamento;
    }

    @Override
    public List<Medicamento> retrieve(String parametro, String atributo) {
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = entityManager.createQuery("Select m From medicamento m "
                + " Where " + atributo + " like ( % " + parametro + " % )", Medicamento.class).getResultList();
        return medicamentos;
    }

    @Override
    public void update(Medicamento objeto) {
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
    public void delete(Medicamento objeto) {
        try {
            Medicamento medicamento = entityManager.find(Medicamento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(medicamento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
