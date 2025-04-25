package service;

import java.util.List;
import model.bo.Consulta;
import model.dao.ConsultaDAO;

public class ServiceConsulta {

    public static void adicionar(Consulta objeto) {
        ConsultaDAO.getInstance().create(objeto);
    }

    public static List<Consulta> ler() {
        return ConsultaDAO.getInstance().retrieve();
    }

    public static Consulta ler(int PK) {
        return ConsultaDAO.getInstance().retrieve(PK);
    }

    public static List<Consulta> ler(String parametro, String atributo) {
        return ConsultaDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Consulta objeto) {
        ConsultaDAO.getInstance().update(objeto);
    }
}
