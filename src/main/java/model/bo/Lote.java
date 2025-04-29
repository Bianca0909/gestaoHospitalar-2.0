package model.bo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "lote")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;
    @Column(name = "data_validade")
    private LocalDate dataValidade;
    @Column(name = "status")
    private String status;
}