package org.example.data;

import org.example.models.Funcionario;
import org.hibernate.SessionFactory;

abstract public class DAO {


     abstract public void adicionar(Funcionario funcionario, SessionFactory sessionFactory);
 }
