/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yuyun
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "from Employee";
            employees = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            employee = (Employee) session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employee> search(String key) {
        List<Employee> employees = new ArrayList();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "from Employee e where lower(firstName) like lower(:key)  "
                    + "or lower(lastName) like lower(:key) or lower(email) like lower(:key)  "
                    + "or lower(jobId) like lower(:key) or departmentId like :key or managerId like :key "
                    + "or phoneNumber like :key or employeeId like :key or salary like :key or commissionPct like :key "
                    + "or hireDate like :key";
            Query queri = session.createQuery(query);
            queri.setParameter("key", "%" + key + "%");
            employees = queri.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public boolean save(Employee em) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(em);
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
    public boolean delete(int id) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            Employee em = (Employee) session.load(Employee.class, id);
            session.delete(em);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }

//    boolean result = false;
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String query = "delete from Employee where employeeId=:id";
//            Query queri = session.createQuery(query);
//            queri.setInteger("id", id);
//            queri.executeUpdate();
//            transaction.commit();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        } finally {
//            session.close();
//        }
//        return result;
}
