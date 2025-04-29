package model.bo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "jornada")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Jornada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_inicial")
    private LocalDate dataInicial;
    @Column(name = "data_final")
    private LocalDate dataFinal;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
    @Column(name = "profissional_id")
    private Integer profissionalId;
}