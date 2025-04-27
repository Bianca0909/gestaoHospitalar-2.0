package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Consulta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(Internacao.class)
public class Internacao_ { 

    public static volatile SingularAttribute<Internacao, LocalDateTime> dataHoraAlta;
    public static volatile SingularAttribute<Internacao, LocalDateTime> dataHoraInternacao;
    public static volatile SingularAttribute<Internacao, String> observacao;
    public static volatile SingularAttribute<Internacao, Integer> id;
    public static volatile SingularAttribute<Internacao, Consulta> consulta;
    public static volatile SingularAttribute<Internacao, String> status;

}