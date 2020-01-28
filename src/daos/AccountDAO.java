/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IAccountDAO;
import models.Account;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author yuyun
 */
public class AccountDAO implements IAccountDAO {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean register(Account a) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(a);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Account getByUsername(String username) {
        Account account = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            account = (Account) session.get(Employee.class, username);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return account;
    }

}
