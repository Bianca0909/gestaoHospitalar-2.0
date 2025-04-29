package model.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada;
    @Column(name = "data_saida")
    private LocalDateTime dataSaida;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;

}
