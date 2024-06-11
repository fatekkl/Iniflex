package org.example.data;

import org.example.models.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FuncionariosDAO{


    public void adicionar(Funcionario funcionario, SessionFactory sessionFactory) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(funcionario);

            transaction.commit();
            session.close();

            System.out.println("rodou");
        } finally {
            sessionFactory.close();
        }
    }
}
