package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Laboratorio;
import model.bo.Medicamento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(LaboratorioMedicamento.class)
public class LaboratorioMedicamento_ { 

    public static volatile SingularAttribute<LaboratorioMedicamento, String> observacao;
    public static volatile SingularAttribute<LaboratorioMedicamento, Medicamento> medicamento;
    public static volatile SingularAttribute<LaboratorioMedicamento, Integer> id;
    public static volatile SingularAttribute<LaboratorioMedicamento, Laboratorio> laboratorio;
    public static volatile SingularAttribute<LaboratorioMedicamento, String> codigoBarras;
    public static volatile SingularAttribute<LaboratorioMedicamento, String> status;

}