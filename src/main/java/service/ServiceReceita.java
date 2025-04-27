package service;

import java.util.List;
import model.bo.Receita;
import model.dao.ReceitaDAO;

public class ServiceReceita {

    public static void adicionar(Receita objeto) {
        ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
        receitaDAO.create(objeto);
    }

    public static List<Receita> ler() {
        ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
        return receitaDAO.retrieve();
    }

    public static Receita ler(int pk) {
        ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
        return receitaDAO.retrieve(pk);
    }

    public static List<Receita> ler(String parametro, String atributo) {
        ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
        return receitaDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Receita objeto) {
        ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
        receitaDAO.update(objeto);
    }
}
