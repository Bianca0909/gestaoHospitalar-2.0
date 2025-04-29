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

@Entity(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "data_hora_consulta")
    private LocalDateTime dataHoraConsulta;
    @Column(name = "anamnese")
    private String anamnese;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "prescricao")
    private String prescricao;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;
    @ManyToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;
}
