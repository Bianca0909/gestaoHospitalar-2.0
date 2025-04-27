package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Consulta;
import model.bo.Exame;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(ConsultaExame.class)
public class ConsultaExame_ { 

    public static volatile SingularAttribute<ConsultaExame, Exame> exame;
    public static volatile SingularAttribute<ConsultaExame, LocalDateTime> dataHoraExame;
    public static volatile SingularAttribute<ConsultaExame, String> imagemExame;
    public static volatile SingularAttribute<ConsultaExame, Integer> id;
    public static volatile SingularAttribute<ConsultaExame, Consulta> consulta;
    public static volatile SingularAttribute<ConsultaExame, String> analiseExame;
    public static volatile SingularAttribute<ConsultaExame, String> status;

}