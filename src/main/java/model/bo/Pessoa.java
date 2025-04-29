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
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "fone1")
    private String fone1;
    @Column(name = "fone2")
    private String fone2;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Column(name = "rg_inscricao_estadual")
    private String rgInscricaoEstadual;
    @Column(name = "data_cadastro")
    private String dataCadastro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;

}
