package org.example.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "funcao")
    private String funcao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public Funcionario() {

    }

    public int getId() {
        return id;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super( nome, dataNascimento );
        this.salario = salario;
        this.funcao = funcao;
        this.id = getId();
    }


    public BigDecimal getSalario() {
        return salario;
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", salario=" + salario +
                ", funcao='" + funcao + '\'' +
                '}';
    }

    public BigDecimal getPorcentagem(Double value) {
        BigDecimal salarioAtual = getSalario();

        return salarioAtual.multiply( BigDecimal.valueOf( value ) );
    }

}
