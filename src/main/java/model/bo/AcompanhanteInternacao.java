package model.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acompanhante_internacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhanteInternacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime dataEntrada;
    @Column
    private LocalDateTime dataSaida;
    @Column
    private String observacao;
    @Column
    private String status;

}
