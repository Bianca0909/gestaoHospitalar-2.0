package model.bo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends Pessoa {
    
    @Column
    private String nomeFantasia;
    @Column
    private String contato;
}
