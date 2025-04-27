package model.bo;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(Lote.class)
public class Lote_ { 

    public static volatile SingularAttribute<Lote, LocalDate> dataValidade;
    public static volatile SingularAttribute<Lote, LocalDate> dataFabricacao;
    public static volatile SingularAttribute<Lote, Integer> id;
    public static volatile SingularAttribute<Lote, String> descricao;
    public static volatile SingularAttribute<Lote, String> status;

}