package service;

import java.util.List;
import model.bo.Prontuario;
import model.dao.ProntuarioDAO;

public class ServiceProntuario {

    public static void adicionar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.create(objeto);
    }

    public static List<Prontuario> ler() {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve();
    }

    public static Prontuario ler(int PK) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve(PK);
    }

    public static List<Prontuario> ler(String parametro, String atributo) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.update(objeto);
    }
}
