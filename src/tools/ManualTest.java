/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.LocationDAO;
import daos.RegionDAO;
import idaos.ILocationDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author yuyun
 */
public class ManualTest {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println(sessionFactory);
//        System.out.println(HibernateUtil.getSessionFactory());

//
//       ----getAll
//                LocationDAO ldao= new LocationDAO(sessionFactory);
//                List<Location> location=ldao.search("9090");
//                for (Location e : location) {
//                    System.out.println(e.getLocationId()+" "+e.getStreetAddress()+" "+e.getPostalCode());
//                }
//      ----GetById
//        ILocationDAO ldao= new LocationDAO(sessionFactory);
//                Location l=ldao.getById(new Short("1200"));
//                System.out.println(l.getLocationId()+" "+l.getStreetAddress()+" "+l.getPostalCode());
//      ----Search
//        ILocationDAO ildao= new LocationDAO(sessionFactory);
//        for (Location location : ildao.search("0")){
//            System.out.println(location.getLocationId());
//            System.out.println(location.getStreetAddress());
//    }
//      ----Save
        ILocationDAO ildao= new LocationDAO(sessionFactory);
        System.out.println(ildao.save(new Location(Short.parseShort("1000"), "1297 Via Cola di Rie", "00989", "Roma", "",new Country("IT"))));
///     ----- Delete        
//        ILocationDAO ildao = new LocationDAO(sessionFactory);
//        System.out.println(ildao.delete(new Short("1111")));

    }
}
