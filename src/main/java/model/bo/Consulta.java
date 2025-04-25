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
    private Integer id;
    @Column
    private String responsavel;
    @Column
    private LocalDateTime dataHoraConsulta;
    @Column
    private String anamnese;
    @Column
    private String diagnostico;
    @Column
    private String prescricao;
    @Column
    private String observacao;
    @Column
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
