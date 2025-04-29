package model.bo;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "movimento_medicamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimentoMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_hora_movimento")
    private LocalDateTime dataHoraMovimento;
    @Column(name = "tipo_movimento")
    private String tipoMovimento;
    @Column(name = "qtd_medicamento")
    private float qtdMedicamento;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
    @ManyToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;
    @ManyToOne
    @JoinColumn(name = "receita_medicamento_id")
    private ReceitaMedicamento receitaMedicamento;
    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
}