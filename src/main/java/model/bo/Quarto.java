package model.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "quarto")
@Table(name = "quarto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quarto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "status")
    private String status;
  
    @ManyToOne
    @JoinColumn(name = "ala_id")
    private Ala ala;
}
