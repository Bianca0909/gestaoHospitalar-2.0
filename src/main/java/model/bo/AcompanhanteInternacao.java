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

@Entity(name = "acompanhante_internacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhanteInternacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "acompanhante_id")
    private Acompanhante acompanhante;

    @ManyToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;

    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada;
    @Column(name = "data_saida")
    private LocalDateTime dataSaida;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;

}
