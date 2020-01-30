/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import idaos.IGeneralDAO;

/**
 *
 * @author aqira
 */
public class GeneralDAO<T> implements IGeneralDAO<T> {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;
    private T t;

    public GeneralDAO(SessionFactory sessionFactory, Class<T> t) {
        try {
            this.sessionFactory = sessionFactory;
            this.t = t.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        List<T> ts = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            ts = session.createQuery("FROM " + t.getClass().getSimpleName()).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return ts;
    }

    @Override
    public T getById(T t) {
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
//            String hql = "FROM " + t.getClass().getSimpleName() + " WHERE "+ t.getClass().getField(t) +" = :a";
//            Query query = session.createQuery(hql);
//            query.setParameter("a", t);
//            t = (T) query.uniqueResult();
            System.out.println(t.getClass().get);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return t;
    }

    @Override
    public List<Region> search(Object key) {
        List<Region> region = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE lower(regionName) LIKE :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", "%" + key.toString().toLowerCase() + "%");
            region = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return region;
    }

    @Override
    public boolean saveOrDelete(T t, boolean isDelete) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(t);
            } else {
                session.saveOrUpdate(t); //insert & update & delete
            }
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
}

