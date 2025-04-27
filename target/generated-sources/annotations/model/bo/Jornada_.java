package model.bo;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(Jornada.class)
public class Jornada_ { 

    public static volatile SingularAttribute<Jornada, Integer> profissionalId;
    public static volatile SingularAttribute<Jornada, Integer> id;
    public static volatile SingularAttribute<Jornada, LocalDate> dataInicial;
    public static volatile SingularAttribute<Jornada, LocalDate> dataFinal;
    public static volatile SingularAttribute<Jornada, Integer> cargaHoraria;

}