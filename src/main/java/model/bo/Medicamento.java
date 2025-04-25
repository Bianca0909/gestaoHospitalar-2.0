package model.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "medicamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String descricaoMedicamento;
    @Column
    private String principioAtivo;
    @Column
    private float qtdMinima;
    @Column
    private String status;
    @Column
    private String codigoBarras;
    @Column
    private Integer laboratorio_id;
}
