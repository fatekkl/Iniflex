package org.example;

import org.example.models.Funcionario;
import org.example.models.Pessoa;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa;
        Funcionario funcionario;
        Configuration configuration = new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        if (sessionFactory != null){
            System.out.println("Conexão feita!");
        }

    }

}


