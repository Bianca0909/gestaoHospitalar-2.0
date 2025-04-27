package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-27T16:45:03")
@StaticMetamodel(AcompanhanteInternacao.class)
public class AcompanhanteInternacao_ { 

    public static volatile SingularAttribute<AcompanhanteInternacao, String> observacao;
    public static volatile SingularAttribute<AcompanhanteInternacao, LocalDateTime> dataEntrada;
    public static volatile SingularAttribute<AcompanhanteInternacao, Integer> id;
    public static volatile SingularAttribute<AcompanhanteInternacao, LocalDateTime> dataSaida;
    public static volatile SingularAttribute<AcompanhanteInternacao, String> status;

}