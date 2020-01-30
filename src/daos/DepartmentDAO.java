/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentDAO;
import idaos.IDepartmentDAO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Department;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author BWP
 */
public class DepartmentDAO implements IDepartmentDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public DepartmentDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<Department> getAll() {
        List<Department> department = new ArrayList<>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Department";
            department = session.createQuery(query).list();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return department;
    }

    @Override
    public Department getById(Short id) {
        Department department = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Department WHERE departmentId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            department = (Department) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return department;
    }

    @Override
    public boolean save(Department department) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            session.saveOrUpdate(department);
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
    public boolean delete(Short id) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            Department department = (Department) session.load(Department.class, id);
            session.delete(department);
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
    public List<Department> search(Object key) {
        List<Department> department = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Department WHERE lower(departmentName) LIKE :a "
                    + "OR lower(managerId) LIKE :a OR lower(locationId) LIKE :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", "%" + key.toString().toLowerCase() + "%");
            department = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return department;
    }
}
