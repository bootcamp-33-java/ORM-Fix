/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author BWP
 */
public class LocationDAO implements ILocationDAO {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public LocationDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "FROM Location";
            locations = session.createQuery(query).list();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return locations;
    }
}
