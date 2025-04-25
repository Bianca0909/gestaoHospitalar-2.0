package model.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity(name = "internacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Internacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime dataHoraInternacao;
    @Column
    private LocalDateTime dataHoraAlta;
    @Column
    private String observacao;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
}
