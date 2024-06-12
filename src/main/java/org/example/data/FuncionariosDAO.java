package org.example.data;

import org.example.models.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FuncionariosDAO {


    public String getFuncionarios(SessionFactory sessionFactory) {

        List<Funcionario> funcionarios = null;

        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery( "FROM Funcionario", Funcionario.class );

            funcionarios = query.getResultList();

        } finally {
            sessionFactory.close();
        }

        return funcionarios.toString();
    }

    public void adicionar(Funcionario funcionario, SessionFactory sessionFactory) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save( funcionario );

            transaction.commit();
            session.close();

            System.out.println( "Funcionário adicionado a tabela!" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(int id, SessionFactory sessionFactory) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "delete from Funcionario where id = :id" );
            query.setParameter( "id", id );
            int result = query.executeUpdate();

            transaction.commit();
            if (result > 0) {
                System.out.println( "Funcionário removido" );
            } else {
                System.out.println( "Nenhum funcionário encontrado com o ID fornecido" );
            }
        }
    }

    public void removerPorNome(String nome, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "delete from Funcionario where nome = :nome" );
            query.setParameter( "nome", nome );
            int result = query.executeUpdate();

            transaction.commit();
            if (result > 0) {
                System.out.println( "Funcionário removido" );
            } else {
                System.out.println( "Nenhum funcionário encontrado com o ID fornecido" );
            }
        }
    }


}
