package service;

import java.util.List;
import model.bo.Farmaceutico;
import model.dao.FarmaceuticoDAO;

public class ServiceFarmaceutico {

    public static void adicionar(Farmaceutico objeto) {
        FarmaceuticoDAO.getInstance().create(objeto);
    }

    public static List<Farmaceutico> ler() {
        return FarmaceuticoDAO.getInstance().retrieve();
    }

    public static Farmaceutico ler(int PK) {
        return FarmaceuticoDAO.getInstance().retrieve(PK);
    }

    public static List<Farmaceutico> ler(String parametro, String atributo) {
        return FarmaceuticoDAO.getInstance().retrieve(parametro, atributo);
    }
    
    public static void atualizar(Farmaceutico objeto){
        FarmaceuticoDAO.getInstance().update(objeto);
    } 
}
