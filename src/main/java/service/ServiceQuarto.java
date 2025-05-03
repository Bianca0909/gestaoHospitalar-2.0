package service;

import java.util.List;
import model.bo.Quarto;
import model.dao.QuartoDAO;
import javax.persistence.PersistenceException;

/**
 * 
 */
public class ServiceQuarto {
    
    public static void adicionar(Quarto objeto) throws PersistenceException {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        quartoDAO.create(objeto);
    }

    public static List<Quarto> ler() throws PersistenceException {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve();
    }

    public static Quarto ler(int pk) throws PersistenceException {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve(pk);
    }

    public static List<Quarto> ler(String parametro, String atributo) throws PersistenceException {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        return quartoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Quarto objeto) throws PersistenceException {
        QuartoDAO quartoDAO = QuartoDAO.getInstance();
        quartoDAO.update(objeto);
    }

    public static boolean excluir(int id) {
        try {
            QuartoDAO quartoDAO = QuartoDAO.getInstance();
            Quarto quarto = quartoDAO.retrieve(id);
            if (quarto != null) {
                quartoDAO.delete(quarto);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
