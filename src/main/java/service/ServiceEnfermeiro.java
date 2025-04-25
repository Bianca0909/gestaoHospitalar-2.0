package service;

import java.util.List;
import model.bo.Enfermeiro;
import model.dao.EnfermeiroDAO;

public class ServiceEnfermeiro {

    public static void adicionar(Enfermeiro objeto) {
        EnfermeiroDAO.getInstance().create(objeto);
    }

    public static List<Enfermeiro> ler() {
        return EnfermeiroDAO.getInstance().retrieve();
    }

    public static Enfermeiro ler(int PK) {
        return EnfermeiroDAO.getInstance().retrieve(PK);
    }

    public static List<Enfermeiro> ler(String parametro, String atributo) {
        return EnfermeiroDAO.getInstance().retrieve(parametro, atributo);
    }
    
    public static void atualizar(Enfermeiro objeto) {
        EnfermeiroDAO.getInstance().update(objeto);
    }
}
