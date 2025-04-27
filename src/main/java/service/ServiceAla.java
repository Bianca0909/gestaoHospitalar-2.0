package service;

import java.util.List;
import model.bo.Ala;
import model.dao.AlaDAO;

public class ServiceAla {

    public static void adicionar(Ala objeto) {
        AlaDAO alaDAO = AlaDAO.getInstance();
        alaDAO.create(objeto);
    }

    public static List<Ala> ler() {
        AlaDAO alaDAO = AlaDAO.getInstance();
        return alaDAO.retrieve();
    }

    public static Ala ler(int PK) {
        AlaDAO alaDAO = AlaDAO.getInstance();
        return alaDAO.retrieve(PK);
    }

    public static List<Ala> ler(String parametro, String atributo) {
        AlaDAO alaDAO = AlaDAO.getInstance();
        return alaDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Ala objeto) {
        AlaDAO alaDAO = AlaDAO.getInstance();
        alaDAO.update(objeto);
    }
}
