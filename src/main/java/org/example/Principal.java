package org.example;

import org.example.data.Banco;
import org.example.data.FuncionariosDAO;
import org.example.models.Funcionario;
import org.example.models.Pessoa;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa;
        Funcionario funcionario;


        BigDecimal salario_maria = BigDecimal.valueOf( 2009.44 );
        BigDecimal salario_joao = BigDecimal.valueOf( 2284.38 );
        BigDecimal salario_caio = BigDecimal.valueOf( 9836.14 );
        BigDecimal salario_miguel = BigDecimal.valueOf( 19119.88 );
        BigDecimal salario_alice = BigDecimal.valueOf( 2234.68 );
        BigDecimal salario_heitor = BigDecimal.valueOf( 1582.72 );
        BigDecimal salario_arthur = BigDecimal.valueOf( 4071.84 );
        BigDecimal salario_laura = BigDecimal.valueOf( 3017.45 );
        BigDecimal salario_heloisa = BigDecimal.valueOf( 1606.85 );
        BigDecimal salario_helena = BigDecimal.valueOf( 2799.93 );

        Funcionario maria = new Funcionario( "Maria", LocalDate.of( 2000, 10, 18 ), salario_maria, "Operador", 1 );
        Funcionario joao = new Funcionario( "Joao", LocalDate.of( 1990, 5, 12 ), salario_joao, "Operador", 2 );
        Funcionario caio = new Funcionario( "Caio", LocalDate.of( 1961, 5, 2 ), salario_caio, "Coordenador", 3 );
        Funcionario miguel = new Funcionario( "Miguel", LocalDate.of( 1988, 10, 14 ), salario_miguel, "Diretor", 4 );
        Funcionario alice = new Funcionario( "Alice", LocalDate.of( 1995, 1, 5 ), salario_alice, "Recepcionista", 5 );
        Funcionario heitor = new Funcionario( "Heitor", LocalDate.of( 1999, 11, 19 ), salario_heitor, "Operador", 6 );
        Funcionario arthur = new Funcionario( "Arthur", LocalDate.of( 1993, 3, 31 ), salario_arthur, "Contador", 7 );
        Funcionario laura = new Funcionario( "Laura", LocalDate.of( 1994, 7, 19 ), salario_laura, "Gerente", 8 );
        Funcionario heloisa = new Funcionario( "Heloisa", LocalDate.of( 2003, 5, 24 ), salario_heloisa, "Eletricista", 9 );
        Funcionario helena = new Funcionario( "Helena", LocalDate.of( 1996, 9, 2 ), salario_helena, "Gerente", 10 );


        SessionFactory sessionFactory = Banco.getSessionFactory();

        FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

        funcionariosDAO.adicionar( joao, sessionFactory );


    }

}