package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Medicamento;
import model.bo.Receita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(ReceitaMedicamento.class)
public class ReceitaMedicamento_ { 

    public static volatile SingularAttribute<ReceitaMedicamento, String> prescricao;
    public static volatile SingularAttribute<ReceitaMedicamento, Receita> receita;
    public static volatile SingularAttribute<ReceitaMedicamento, Medicamento> medicamento;
    public static volatile SingularAttribute<ReceitaMedicamento, Integer> id;
    public static volatile SingularAttribute<ReceitaMedicamento, String> status;

}