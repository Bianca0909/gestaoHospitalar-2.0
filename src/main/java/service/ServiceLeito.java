package service;

import java.util.List;
import model.bo.Leito;
import model.dao.LeitoDAO;

public class ServiceLeito {

    public static void adicionar(Leito objeto) {
        LeitoDAO leitoDAO = LeitoDAO.getInstance();
        leitoDAO.create(objeto);
    }

    public static List<Leito> ler() {
        LeitoDAO leitoDAO = LeitoDAO.getInstance();
        return leitoDAO.retrieve();
    }

    public static Leito ler(int pk) {
        LeitoDAO leitoDAO = LeitoDAO.getInstance();
        return leitoDAO.retrieve(pk);
    }

    public static List<Leito> ler(String parametro, String atributo) {
        LeitoDAO leitoDAO = LeitoDAO.getInstance();
        return leitoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Leito objeto) {
        LeitoDAO leitoDAO = LeitoDAO.getInstance();
        leitoDAO.update(objeto);
    }
}
