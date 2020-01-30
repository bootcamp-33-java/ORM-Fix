/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import idaos.ILocationDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author M. Farij Ariefqy Saputra
 */
public class LocationDAO implements ILocationDAO {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;

    public LocationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Location";
            locations = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {

            }
        }
        return locations;
    }

    @Override
    public Location getById(Short id) {
        Location locations = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            locations = (Location) session.get(Location.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return locations;

    }

    @Override
    public List<Location> search(Object key) {
        List<Location> location = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Location WHERE lower (location_id) LIKE :a  "
                    + "OR lower (street_address) LIKE  :a OR lower (postal_code) "
                    + "LIKE  :a OR lower (city) LIKE  :a OR lower (state_province) LIKE "
                    + " :a OR lower (country_id) LIKE  :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", key.toString().toLowerCase() + "%");
            location = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return location;

    }

    @Override
    public boolean save(Location l) {
      
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {

            session.saveOrUpdate(l);
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

        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        boolean result = false;
        try {
            Location location = (Location) session.load(Location.class, id);
            session.delete(location);
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
