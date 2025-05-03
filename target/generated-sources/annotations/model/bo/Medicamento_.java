package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Laboratorio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-02T22:02:00")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, Float> qtdMinima;
    public static volatile SingularAttribute<Medicamento, String> principioAtivo;
    public static volatile SingularAttribute<Medicamento, String> descricaoMedicamento;
    public static volatile SingularAttribute<Medicamento, Integer> id;
    public static volatile SingularAttribute<Medicamento, String> codigoBarras;
    public static volatile SingularAttribute<Medicamento, Laboratorio> laboratorioId;
    public static volatile SingularAttribute<Medicamento, String> status;

}