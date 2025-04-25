package service;

import java.util.List;
import model.bo.Exame;
import model.dao.ExameDAO;

public class ServiceExame {

    public static void adicionar(Exame objeto) {
        ExameDAO.getInstance().create(objeto);
    }

    public static List<Exame> ler() {
        return ExameDAO.getInstance().retrieve();
    }

    public static Exame ler(int PK) {
        return ExameDAO.getInstance().retrieve(PK);
    }

    public static List<Exame> ler(String parametro, String atributo) {
        return ExameDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Exame objeto) {
        ExameDAO.getInstance().update(objeto);
    }
}
