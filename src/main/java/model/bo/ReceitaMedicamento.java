package model.bo;

import java.io.Serializable;
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

@Entity(name = "receita_medicamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaMedicamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "prescricao")
    private String prescricao;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;
    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;
}
