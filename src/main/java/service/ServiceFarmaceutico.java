package service;

import java.util.List;
import model.bo.Farmaceutico;
import model.dao.FarmaceuticoDAO;

public class ServiceFarmaceutico {

    public static void adicionar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = FarmaceuticoDAO.getInstance();
        farmaceuticoDAO.create(objeto);
    }

    public static List<Farmaceutico> ler() {
        FarmaceuticoDAO farmaceuticoDAO = FarmaceuticoDAO.getInstance();
        return farmaceuticoDAO.retrieve();
    }

    public static Farmaceutico ler(int pk) {
        FarmaceuticoDAO farmaceuticoDAO = FarmaceuticoDAO.getInstance();
        return farmaceuticoDAO.retrieve(pk);
    }

    public static List<Farmaceutico> ler(String parametro, String atributo) {
        FarmaceuticoDAO farmaceuticoDAO = FarmaceuticoDAO.getInstance();
        return farmaceuticoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = FarmaceuticoDAO.getInstance();
        farmaceuticoDAO.update(objeto);
    }
}
