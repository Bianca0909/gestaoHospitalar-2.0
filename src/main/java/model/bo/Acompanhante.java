
package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acompanhante implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String grauParentesco;
    @Column
    private String cpf;
    @Column
    private String fone;
    @Column
    private String email;
    @Column
    private String status;
    
    public Acompanhante(){
        
    }

    public Acompanhante(Integer id, String nome, String grauParentesco, String cpf, String fone, String email, String status) {
        this.id = id;
        this.nome = nome;
        this.grauParentesco = grauParentesco;
        this.cpf = cpf;
        this.fone = fone;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }      

    @Override
    public String toString() {
        return "Acompanhante{" + "id=" + id + ", nome=" + nome + ", grauParentesco=" + grauParentesco + ", cpf=" + cpf + ", fone=" + fone + ", email=" + email + ", status=" + status + "}\n";
    }
}
