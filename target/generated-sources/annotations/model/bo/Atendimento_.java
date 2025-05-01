package model.bo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Enfermeiro;
import model.bo.Paciente;
import model.bo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-01T15:38:00")
@StaticMetamodel(Atendimento.class)
public class Atendimento_ { 

    public static volatile SingularAttribute<Atendimento, Enfermeiro> enfermeiro;
    public static volatile SingularAttribute<Atendimento, String> oximetria;
    public static volatile SingularAttribute<Atendimento, String> alergias;
    public static volatile SingularAttribute<Atendimento, LocalDateTime> dataHoraAtendimento;
    public static volatile SingularAttribute<Atendimento, String> observacoes;
    public static volatile SingularAttribute<Atendimento, String> historicoDeDoencas;
    public static volatile SingularAttribute<Atendimento, String> pressao;
    public static volatile SingularAttribute<Atendimento, Paciente> paciente;
    public static volatile SingularAttribute<Atendimento, String> classificacao;
    public static volatile SingularAttribute<Atendimento, Usuario> usuario;
    public static volatile SingularAttribute<Atendimento, Integer> id;
    public static volatile SingularAttribute<Atendimento, String> anamnese;
    public static volatile SingularAttribute<Atendimento, String> temperatura;
    public static volatile SingularAttribute<Atendimento, String> medicacoesEmUso;
    public static volatile SingularAttribute<Atendimento, String> bpm;
    public static volatile SingularAttribute<Atendimento, String> tipoAtendimento;
    public static volatile SingularAttribute<Atendimento, String> status;

}