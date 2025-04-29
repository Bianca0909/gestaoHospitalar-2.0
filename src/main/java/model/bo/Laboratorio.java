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

@Entity(name = "laboratorio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laboratorio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "contato")
    private String contato;
    @Column(name = "status")
    private String status;
}
