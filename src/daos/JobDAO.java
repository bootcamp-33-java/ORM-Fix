/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import idaos.IJobDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Insane
 */
public class JobDAO implements IJobDAO {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public JobDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "from Job";
            jobs = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return jobs;
//        ini
    }

    @Override
    public List<Job> search(Object key) {
        List<Job> job = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Job WHERE lower(jobId) LIKE :a OR lower(jobTitle) "
                    + "LIKE :a OR lower(minSalary) LIKE :a OR lower(maxSalary) LIKE :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", "%" + key.toString().toLowerCase() + "%");
            job = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return job;
    }

    @Override
    public boolean save(Job j) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            session.saveOrUpdate(j);
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
    public boolean delete(String id) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            Job job = (Job) session.load(Job.class, id);
            session.delete(job);
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
    public Job getById(String id) {
        Job job = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "From Job WHERE jobId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            job = (Job) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();

            }
        }
        return job;
    }

}
