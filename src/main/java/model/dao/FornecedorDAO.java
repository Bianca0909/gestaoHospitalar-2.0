package model.dao;

import java.util.List;
import model.bo.Fornecedor;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    private static FornecedorDAO instance;
    protected EntityManager entityManager;

    private FornecedorDAO() {
        entityManager = getEntityManager();
    }

    public static FornecedorDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorDAO();
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
    public void create(Fornecedor objeto) {
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
    public List<Fornecedor> retrieve() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedores = entityManager.createQuery("Select f From fornecedor f", Fornecedor.class).getResultList();
        return fornecedores;
    }

    @Override
    public Fornecedor retrieve(int pk) {
        Fornecedor fornecedor = entityManager.find(Fornecedor.class, pk);
        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(String parametro, String atributo) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedores = entityManager.createQuery("Select f From Fornecedor f "
                + " Where " + atributo + " like ( % " + parametro + " % )", Fornecedor.class).getResultList();
        return fornecedores;
    }

    @Override
    public void update(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {
        try {
            Fornecedor fornecedor = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
