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
    private Integer id;
    
    @Column
    private LocalDateTime dataHoraAtendimento;
    
    @Column
    private String pressao;
    
    @Column
    private String temperatura;
    
    @Column
    private String bpm;
    
    @Column
    private String oximetria;
    
    @Column
    private String historicoDeDoencas;
    
    @Column
    private String alergias;
    
    @Column
    private String medicacoesEmUso;
    
    @Column
    private String anamnese;
    
    @Column
    private String tipoAtendimento;
    
    @Column
    private String classificacao;
    
    @Column
    private String observacoes;
    
    @Column
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
