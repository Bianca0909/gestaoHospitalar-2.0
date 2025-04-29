package model.bo;

import java.io.Serializable;
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

@Entity(name = "consulta_exame")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaExame implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_hora_exame")
    private LocalDateTime dataHoraExame;
    @Column(name = "analise_exame")
    private String analiseExame;
    @Column(name = "imagem_exame")
    private String imagemExame;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
    @ManyToOne
    @JoinColumn(name = "exame_id")
    private Exame exame;
}
