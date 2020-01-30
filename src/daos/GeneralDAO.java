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
import idaos.IRegionDAO;
import idaos.ICountryDAO;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import icontrollers.IGeneralDAO;

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

//    @Override
//    @Override
    public List<T> getAll() {
        List<T> ts = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ts = session.createQuery("FROM " + t.getClass().getSimpleName()).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return ts;
    }

//    @Override
//    public Region getById(BigDecimal id) {
//        Region region = null;
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String hql = "FROM Region WHERE regionId = :a";
//            Query query = session.createQuery(hql);
//            query.setParameter("a", id);
//            region = (Region) query.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return region;
//    }
//    @Override
//    public List<T> search(Object key) {
//        List<T> region = new ArrayList<>();
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String hql = "FROM Region WHERE lower(regionName) LIKE :a";
//            Query query = session.createQuery(hql);
//            query.setParameter("a", "%" + key.toString().toLowerCase() + "%");
//            region = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return region;
//    }

//    @Override
//    public boolean delete(T t) {
//        boolean result = false;
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
////            Region region = (Region) session.load(Region.class, id);
//            session.delete(t); //delete
//            transaction.commit();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return result;
//    }
//    @Override
//    @Override
    public boolean saveOrDelete(T t, boolean isDelete) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(t);
            } else {
                session.saveOrUpdate(t);
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
    
//    @Override
    public void search(){
        List<String> key = new ArrayList<>();
        for (Field declaredField : t.getClass().getDeclaredFields()) {
            System.out.println(declaredField);
        }
        
    }
    
//    @Override
        public T getById(T t) {
    //        Country region = null;
//            List<T> l = new ArrayList<>();
            try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
//                l = session.createQuery("FROM " + t.getClass().getSimpleName()+"WHERE "+ t.getClass().getDeclaredField(id));
//                String hql = "from Country WHERE countryId = :a";
//                Query query = session.createQuery(hql);
//                query.setParameter("a", id);
//                l = (T )query.uniqueResult();
                System.out.println(t.getClass().getSimpleName());
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return t;
        }
}
