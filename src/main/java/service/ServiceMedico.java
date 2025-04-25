package service;

import java.util.List;
import model.bo.Medico;
import model.dao.MedicoDAO;

public class ServiceMedico {

    public static void adicionar(Medico objeto) {
        MedicoDAO.getInstance().create(objeto);
    }

    public static List<Medico> ler() {
        return MedicoDAO.getInstance().retrieve();
    }

    public static Medico ler(int PK) {
        return MedicoDAO.getInstance().retrieve(PK);
    }

    public static List<Medico> ler(String parametro, String atributo) {
        return MedicoDAO.getInstance().retrieve(parametro, atributo);
    }
    
    public static void atualizar(Medico objeto){
        MedicoDAO.getInstance().update(objeto);
    } 
}
