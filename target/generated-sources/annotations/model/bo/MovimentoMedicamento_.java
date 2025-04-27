package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Laboratorio;
import model.bo.Lote;
import model.bo.Prontuario;
import model.bo.ReceitaMedicamento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(MovimentoMedicamento.class)
public class MovimentoMedicamento_ { 

    public static volatile SingularAttribute<MovimentoMedicamento, ReceitaMedicamento> receitaMedicamento;
    public static volatile SingularAttribute<MovimentoMedicamento, String> observacao;
    public static volatile SingularAttribute<MovimentoMedicamento, Prontuario> prontuario;
    public static volatile SingularAttribute<MovimentoMedicamento, Lote> lote;
    public static volatile SingularAttribute<MovimentoMedicamento, Float> qtdMedicamento;
    public static volatile SingularAttribute<MovimentoMedicamento, LocalDateTime> dataHoraMovimento;
    public static volatile SingularAttribute<MovimentoMedicamento, Integer> id;
    public static volatile SingularAttribute<MovimentoMedicamento, Laboratorio> laboratorio;
    public static volatile SingularAttribute<MovimentoMedicamento, String> tipoMovimento;
    public static volatile SingularAttribute<MovimentoMedicamento, String> status;

}