package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Enfermeiro;
import model.bo.InternacaoLeito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-01T15:38:00")
@StaticMetamodel(Prontuario.class)
public class Prontuario_ { 

    public static volatile SingularAttribute<Prontuario, String> observacao;
    public static volatile SingularAttribute<Prontuario, Enfermeiro> enfermeiro;
    public static volatile SingularAttribute<Prontuario, String> descricaoVista;
    public static volatile SingularAttribute<Prontuario, InternacaoLeito> internacaoLeito;
    public static volatile SingularAttribute<Prontuario, LocalDateTime> dataHoraVisita;
    public static volatile SingularAttribute<Prontuario, Integer> id;
    public static volatile SingularAttribute<Prontuario, String> status;

}