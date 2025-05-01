package service;

import java.util.List;
import model.bo.Usuario;
import model.dao.UsuarioDAO;

public class ServiceUsuario {

    public static Usuario inserir(Usuario objeto) {
        UsuarioDAO.getInstance().create(objeto);
        return objeto;
    }

    public static List<Usuario> ler() {
        return UsuarioDAO.getInstance().retrieve();
    }

    public static Usuario ler(int pk) {
        return UsuarioDAO.getInstance().retrieve(pk);
    }

    public static List<Usuario> ler(String parametro, String atributo) {
        return UsuarioDAO.getInstance().retrieve(parametro, atributo);
    }

    public static Usuario atualizar(Usuario objeto) {
        UsuarioDAO.getInstance().update(objeto);
        return objeto;
    }

    public static boolean excluir(int id) {
        try {
            Usuario usuario = UsuarioDAO.getInstance().retrieve(id);
            if (usuario != null) {
                UsuarioDAO.getInstance().delete(usuario);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
