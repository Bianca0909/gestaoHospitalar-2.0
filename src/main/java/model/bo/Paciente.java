package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Paciente extends Pessoa {
    
    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "nome_social")
    private String nomeSocial;
}
