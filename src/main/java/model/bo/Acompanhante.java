package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "acompanhante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhante implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "fone")
    private String fone;

    @Column(name = "email")
    private String email;

    @Column(name = "grau_parentesco")
    private String grauParentesco;
    
    @Column(name = "status")
    private String status;
    
}
