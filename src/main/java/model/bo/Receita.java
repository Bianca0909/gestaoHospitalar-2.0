package model.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "receita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receita implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_hora_receita")
    private LocalDateTime dataHoraReceita;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;
}
