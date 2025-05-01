package service;

import java.util.List;
import model.bo.Acompanhante;
import model.dao.AcompanhanteDAO;

public class ServiceAcompanhante {
     public static void adicionar(Acompanhante objeto) {
        AcompanhanteDAO.getInstance().create(objeto);
    }

    public static List<Acompanhante> ler() {
        return AcompanhanteDAO.getInstance().retrieve();
    }

    public static Acompanhante ler(int PK) {
        return AcompanhanteDAO.getInstance().retrieve(PK);
    }

    public static List<Acompanhante> ler(String parametro, String atributo) {
        return AcompanhanteDAO.getInstance().retrieve(parametro, atributo);
    }
    
    public static void atualizar(Acompanhante objeto){
        AcompanhanteDAO.getInstance().update(objeto);
    } 

    public static boolean excluir(int id) {
        try {
            Acompanhante acompanhante = AcompanhanteDAO.getInstance().retrieve(id);
            if (acompanhante != null) {
                AcompanhanteDAO.getInstance().delete(acompanhante);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
