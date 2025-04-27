package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Atendimento;
import model.bo.Internacao;
import model.bo.Medico;
import model.bo.Receita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(Consulta.class)
public class Consulta_ { 

    public static volatile SingularAttribute<Consulta, String> prescricao;
    public static volatile SingularAttribute<Consulta, String> observacao;
    public static volatile SingularAttribute<Consulta, Receita> receita;
    public static volatile SingularAttribute<Consulta, String> diagnostico;
    public static volatile SingularAttribute<Consulta, Medico> medico;
    public static volatile SingularAttribute<Consulta, Internacao> internacao;
    public static volatile SingularAttribute<Consulta, Atendimento> atendimento;
    public static volatile SingularAttribute<Consulta, Integer> id;
    public static volatile SingularAttribute<Consulta, String> anamnese;
    public static volatile SingularAttribute<Consulta, String> responsavel;
    public static volatile SingularAttribute<Consulta, LocalDateTime> dataHoraConsulta;
    public static volatile SingularAttribute<Consulta, String> status;

}