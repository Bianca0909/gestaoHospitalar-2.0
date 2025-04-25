package model.bo;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String fone1;
    @Column
    private String fone2;
    @Column
    private String email;
    @Column
    private String cpfCnpj;
    @Column
    private String rgInscricaoEstadual;
    @Column
    private String dataCadastro;
    @Column
    private String cep;
    @Column
    private String cidade;
    @Column
    private String bairro;
    @Column
    private String logradouro;
    @Column
    private String complemento;

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", fone1=" + fone1 + ", fone2=" + fone2 + ", email=" + email + ", cpfCnpj=" + cpfCnpj + ", rgInscricaoEstadual=" + rgInscricaoEstadual + ", dataCadastro=" + dataCadastro + ", cep=" + cep + ", cidade=" + cidade + ", bairro=" + bairro + ", logradouro=" + logradouro + ", complemento=" + complemento + '}';
    }

}
