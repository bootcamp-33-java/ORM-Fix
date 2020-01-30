/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountryDAO;
import idaos.ICountryDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Tutus
 */
public class CountryDAO implements ICountryDAO{
    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

//    @Override
//    public boolean insert(Country country) {
//        boolean result = false;
//
//        try {
//            session = this.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.(country);
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

    @Override
    public List<Country> getAll() {
        List<Country> regions = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Country";
            regions = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return regions;
    }

    @Override
    public Country getById(String id) {
        Country region = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from Country WHERE countryId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            region = (Country) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public List<Country> search(String keyword) {
        List<Country> countrys = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Country WHERE lower (country_id) LIKE :a "
                    + "OR lower (country_name) LIKE :a OR (region_id) LIKE :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", keyword.toString().toLowerCase() + "%");
            countrys = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return countrys;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
//    @Override
//    public boolean update(Country country) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean delete(String id) {
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            Country country = (Country) session.load(Country.class, id);
            session.delete(country);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally{
            session.close();
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Country country) {
        boolean result = false;
            try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(country);
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
