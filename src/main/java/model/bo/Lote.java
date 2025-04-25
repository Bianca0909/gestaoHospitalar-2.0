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
    private Integer id;
    @Column
    private String descricao;
    @Column
    private LocalDate dataFabricacao;
    @Column
    private LocalDate dataValidade;
    @Column
    private String status;
}