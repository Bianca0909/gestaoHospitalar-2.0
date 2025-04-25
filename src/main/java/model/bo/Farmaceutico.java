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
    
    @Column
    private String crf;
    @Column
    private String senha;
    @Column
    private String login;
    @Column
    private String nomeSocial;
}
