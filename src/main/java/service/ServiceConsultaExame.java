package service;

import java.util.List;
import model.bo.ConsultaExame;
import model.dao.ConsultaExameDAO;

public class ServiceConsultaExame {

    public static void adicionar(ConsultaExame objeto) {
        ConsultaExameDAO.getInstance().create(objeto);
    }

    public static List<ConsultaExame> ler() {
        return ConsultaExameDAO.getInstance().retrieve();
    }

    public static ConsultaExame ler(int PK) {
        return ConsultaExameDAO.getInstance().retrieve(PK);
    }

    public static List<ConsultaExame> ler(String parametro, String atributo) {
        return ConsultaExameDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(ConsultaExame objeto) {
        ConsultaExameDAO.getInstance().update(objeto);
    }
}
