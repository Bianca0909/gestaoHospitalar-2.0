package model.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao_medicamento")
    private String descricaoMedicamento;
    @Column(name = "principio_ativo")
    private String principioAtivo;
    @Column(name = "qtd_minima")
    private float qtdMinima;
    @Column(name = "status")
    private String status;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @ManyToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorioId;
}
