package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Medico extends Pessoa {
    
    @Column(name = "crm")
    private String crm;
    @Column(name = "senha")
    private String senha;
    @Column(name = "login")
    private String login;
    @Column(name = "nome_social")
    private String nomeSocial;
}
