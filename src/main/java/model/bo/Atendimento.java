package model.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "atendimento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "data_hora_atendimento")
    private LocalDateTime dataHoraAtendimento;
    
    @Column(name = "pressao")
    private String pressao;
    
    @Column(name = "temperatura")
    private String temperatura;
    
    @Column(name = "bpm")
    private String bpm;
    
    @Column(name = "oximetria")
    private String oximetria;
    
    @Column(name = "historico_doencas")
    private String historicoDeDoencas;
    
    @Column(name = "alergias")
    private String alergias;
    
    @Column(name = "medicacoes_em_uso")
    private String medicacoesEmUso;
    
    @Column(name = "anamnese")
    private String anamnese;
    
    @Column(name = "tipo_atendimento")
    private String tipoAtendimento;
    
    @Column(name = "classificacao")
    private String classificacao;
    
    @Column(name = "observacoes")
    private String observacoes;
    
    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "enfermeiro_id")
    private Enfermeiro enfermeiro;
}
