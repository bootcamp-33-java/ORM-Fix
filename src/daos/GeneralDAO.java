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

/**
 *
 * @author aqira
 */
public class GeneralDAO<T> {

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

//    @Override
    public List<T> getAll() {
        List<T> rs = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            rs = session.createQuery("FROM " + t.getClass().getSimpleName()).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return rs;
    }

//    @Override
    public Region getById(BigDecimal id) {
        Region region = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

//    @Override
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

//    @Override
    public boolean delete(BigDecimal id) {
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            Region region = (Region) session.load(Region.class, id);
            session.delete(region); //delete
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

//    @Override
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
