package service;

import java.util.List;
import model.bo.Jornada;
import model.dao.JornadaDAO;

public class ServiceJornada {

    public static void adicionar(Jornada objeto) {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        jornadaDAO.create(objeto);
    }

    public static List<Jornada> ler() {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        return jornadaDAO.retrieve();
    }

    public static Jornada ler(int pk) {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        return jornadaDAO.retrieve(pk);
    }

    public static List<Jornada> ler(String parametro, String atributo) {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        return jornadaDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Jornada objeto) {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        jornadaDAO.update(objeto);
    }

    public static void deletar(Jornada objeto) {
        JornadaDAO jornadaDAO = JornadaDAO.getInstance();
        jornadaDAO.delete(objeto);
    }
}
