package model.bo;

import javax.persistence.Entity;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "acompanhante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Acompanhante extends Pessoa {
    
    @Column
    private String grauParentesco;
    @Column
    private String status;
    
    public String getCpf() {
        return getCpfCnpj();
    }
    
    public void setCpf(String cpf) {
        setCpfCnpj(cpf);
    }
    
    public String getFone() {
        return getFone1();
    }
    
    public void setFone(String fone) {
        setFone1(fone);
    }
}
