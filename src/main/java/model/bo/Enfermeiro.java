package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "enfermeiro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Enfermeiro extends Pessoa {
    
    @Column(name = "cre")
    private String cre;
    @Column(name = "senha")
    private String senha;
    @Column(name = "login")
    private String login;
    @Column(name = "nome_social")
    private String nomeSocial;
    @Column(name = "status")
    private String status;
}
