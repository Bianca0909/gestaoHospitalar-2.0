package service;

import java.util.List;
import model.bo.Exame;
import model.dao.ExameDAO;

public class ServiceExame {

    public static void adicionar(Exame objeto) {
        ExameDAO exameDAO = ExameDAO.getInstance();
        exameDAO.create(objeto);
    }

    public static List<Exame> ler() {
        ExameDAO exameDAO = ExameDAO.getInstance();
        return exameDAO.retrieve();
    }

    public static Exame ler(int pk) {
        ExameDAO exameDAO = ExameDAO.getInstance();
        return exameDAO.retrieve(pk);
    }

    public static List<Exame> ler(String parametro, String atributo) {
        ExameDAO exameDAO = ExameDAO.getInstance();
        return exameDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Exame objeto) {
        ExameDAO exameDAO = ExameDAO.getInstance();
        exameDAO.update(objeto);
    }
}
