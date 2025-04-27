package service;

import java.util.List;
import model.bo.Usuario;
import model.dao.UsuarioDAO;

public class ServiceUsuario {

    public static void adicionar(Usuario objeto) {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        usuarioDAO.create(objeto);
    }

    public static List<Usuario> ler() {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        return usuarioDAO.retrieve();
    }

    public static Usuario ler(int pk) {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        return usuarioDAO.retrieve(pk);
    }

    public static List<Usuario> ler(String parametro, String atributo) {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        return usuarioDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Usuario objeto) {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        usuarioDAO.update(objeto);
    }
}
