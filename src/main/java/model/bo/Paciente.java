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
    
    @Column
    private String cartaoSus;
    @Column
    private String tipoSanguineo;
    @Column
    private String sexo;
    @Column
    private String nomeSocial;
    @Column
    private String convenio;
    @Column
    private String carteirinhaConvenio;
    @Column
    private String status;
}
