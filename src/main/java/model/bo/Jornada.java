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
    private Integer id;
    @Column
    private LocalDate dataInicial;
    @Column
    private LocalDate dataFinal;
    @Column
    private Integer cargaHoraria;
    @Column
    private Integer profissionalId;
}
