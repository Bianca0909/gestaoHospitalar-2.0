package service;

import java.util.List;
import model.bo.Enfermeiro;
import model.dao.EnfermeiroDAO;

public class ServiceEnfermeiro {

    public static void adicionar(Enfermeiro objeto) {
        EnfermeiroDAO enfermeiroDAO = EnfermeiroDAO.getInstance();
        enfermeiroDAO.create(objeto);
    }

    public static List<Enfermeiro> ler() {
        EnfermeiroDAO enfermeiroDAO = EnfermeiroDAO.getInstance();
        return enfermeiroDAO.retrieve();
    }

    public static Enfermeiro ler(int pk) {
        EnfermeiroDAO enfermeiroDAO = EnfermeiroDAO.getInstance();
        return enfermeiroDAO.retrieve(pk);
    }

    public static List<Enfermeiro> ler(String parametro, String atributo) {
        EnfermeiroDAO enfermeiroDAO = EnfermeiroDAO.getInstance();
        return enfermeiroDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Enfermeiro objeto) {
        EnfermeiroDAO enfermeiroDAO = EnfermeiroDAO.getInstance();
        enfermeiroDAO.update(objeto);
    }
}
