package model.dao;

import java.util.List;
import model.bo.Usuario;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

    private static UsuarioDAO instance;
    protected EntityManager entityManager;

    private UsuarioDAO() {
        entityManager = getEntityManager();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
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
    public void create(Usuario objeto) {
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
    public List<Usuario> retrieve() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = entityManager.createQuery("Select u From usuario u", Usuario.class).getResultList();
        return usuarios;
    }

    @Override
    public Usuario retrieve(int pk) {
        Usuario usuario = entityManager.find(Usuario.class, pk);
        return usuario;
    }

    @Override
    public List<Usuario> retrieve(String parametro, String atributo) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = entityManager.createQuery("Select u From usuario u "
                + " Where " + atributo + " like ( % " + parametro + " % )", Usuario.class).getResultList();
        return usuarios;
    }

    @Override
    public void update(Usuario objeto) {
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
    public void delete(Usuario objeto) {
        try {
            Usuario usuario = entityManager.find(Usuario.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
