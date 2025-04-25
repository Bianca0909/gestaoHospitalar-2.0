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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "internacao_leito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternacaoLeito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime dataHoraAlocacao;
    @Column
    private LocalDateTime dataHoraDesocupacao;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;
    @ManyToOne
    @JoinColumn(name = "leito_id")
    private Leito leito;
    @ManyToOne
    @JoinColumn(name = "acompanhante_id")
    private Acompanhante acompanhante;
}
