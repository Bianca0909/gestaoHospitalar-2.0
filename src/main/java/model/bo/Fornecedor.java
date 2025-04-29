package model.bo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity(name = "fornecedor")
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends Pessoa {
    
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "contato")
    private String contato;
}
