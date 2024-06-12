package org.example.data;

import org.example.models.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionariosDAO {

    private final SessionFactory sessionFactory;

    public FuncionariosDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public String getFuncionarios() {

        List funcionarios = null;

        try {
            Session session = sessionFactory.openSession();

            Query query = session.createQuery( "FROM Funcionario", Funcionario.class );

            funcionarios = query.getResultList();

        } finally {
            sessionFactory.close();
        }

        return funcionarios.toString();
    }

    public void adicionar(Funcionario funcionario) {
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

    public void remover(int id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "delete from Funcionario where id = :id" );
            query.setParameter( "id", id );
            int result = query.executeUpdate();

            transaction.commit();
            session.close();
            if (result > 0) {
                System.out.println( "Funcionário removido" );
            } else {
                System.out.println( "Nenhum funcionário encontrado com o ID fornecido" );
            }
        }
    }

    public void atualizarSalario(int id, BigDecimal novoSalario) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery( "update Funcionario set salario = :novoSalario where id = :id" );
            query.setParameter( "novoSalario", novoSalario );
            query.setParameter( "id", id );
            int result = query.executeUpdate();
            transaction.commit();
            if (result > 0) {
                System.out.println( "Salário atualizado" );
            } else {
                System.out.println( "Nenhum funcionário encontrado com o ID fornecido" );
            }
        }
    }


    public List<Funcionario> getPorFuncao(String funcao) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(
                    "FROM Funcionario WHERE funcao = :funcao", Funcionario.class);

            query.setParameter("funcao", funcao);


            return query.getResultList();
        }
    }

    public Map<String, List> toMap(List lista, String funcao) {
        try(Session session = sessionFactory.openSession()) {
            Map<String, List> map = new HashMap<>();

            map.put(funcao, lista);

            return map;
        }
    }
}
