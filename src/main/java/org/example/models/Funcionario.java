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
    private int id;

    public Funcionario() {

    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Getters e Setters
}
