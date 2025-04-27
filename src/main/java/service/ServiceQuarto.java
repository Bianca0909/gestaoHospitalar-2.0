package service;

import java.util.List;
import model.bo.Quarto;
import model.dao.QuartoDAO;

/**
 * 
 */
public class ServiceQuarto {
    
    public static void adicionar(Quarto objeto) {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        quartoDAO.create(objeto);
    }

    public static List<Quarto> ler() {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve();
    }

    public static Quarto ler(int pk) {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve(pk);
    }

    public static List<Quarto> ler(String parametro, String atributo) {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Quarto objeto){
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        quartoDAO.update(objeto);
    }
}
