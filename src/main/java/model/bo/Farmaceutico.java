package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "farmaceutico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Farmaceutico extends Pessoa {
    
    @Column(name = "crf")
    private String crf;
    @Column(name = "senha")
    private String senha;
    @Column(name = "login")
    private String login;
    @Column(name = "nome_social")
    private String nomeSocial;
}
