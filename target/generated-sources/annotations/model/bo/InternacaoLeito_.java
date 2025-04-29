package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Acompanhante;
import model.bo.Internacao;
import model.bo.Leito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-04-28T18:20:53")
@StaticMetamodel(InternacaoLeito.class)
public class InternacaoLeito_ { 

    public static volatile SingularAttribute<InternacaoLeito, Acompanhante> acompanhante;
    public static volatile SingularAttribute<InternacaoLeito, LocalDateTime> dataHoraAlocacao;
    public static volatile SingularAttribute<InternacaoLeito, Internacao> internacao;
    public static volatile SingularAttribute<InternacaoLeito, Leito> leito;
    public static volatile SingularAttribute<InternacaoLeito, Integer> id;
    public static volatile SingularAttribute<InternacaoLeito, LocalDateTime> dataHoraDesocupacao;
    public static volatile SingularAttribute<InternacaoLeito, String> status;

}