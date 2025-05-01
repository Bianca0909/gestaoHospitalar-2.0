package service;

import java.util.List;
import model.bo.Ala;
import model.dao.AlaDAO;

public class ServiceAla {

    public static Ala inserir(Ala objeto) {
        AlaDAO.getInstance().create(objeto);
        return objeto;
    }

    public static List<Ala> ler() {
        return AlaDAO.getInstance().retrieve();
    }

    public static Ala ler(int PK) {
        return AlaDAO.getInstance().retrieve(PK);
    }

    public static List<Ala> ler(String parametro, String atributo) {
        return AlaDAO.getInstance().retrieve(parametro, atributo);
    }

    public static Ala atualizar(Ala objeto) {
        AlaDAO.getInstance().update(objeto);
        return objeto;
    }

    public static boolean excluir(int id) {
        try {
            Ala ala = AlaDAO.getInstance().retrieve(id);
            if (ala != null) {
                AlaDAO.getInstance().delete(ala);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
