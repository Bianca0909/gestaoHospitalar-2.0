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

@Entity(name = "laboratorio_medicamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioMedicamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String codigoBarras;
    @Column
    private String observacao;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;
    @ManyToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;
}
