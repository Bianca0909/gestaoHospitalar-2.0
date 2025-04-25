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

@Entity(name = "prontuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime dataHoraVisita;
    @Column
    private String descricaoVista;
    @Column
    private String observacao;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "internacao_leito_id")
    private InternacaoLeito internacaoLeito;
    @ManyToOne
    @JoinColumn(name = "enfermeiro_id")
    private Enfermeiro enfermeiro;
}
