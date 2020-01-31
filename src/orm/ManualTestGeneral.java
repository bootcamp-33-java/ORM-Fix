/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import models.Account;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author aqira
 */
public class ManualTestGeneral {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ---------------------------------------- Deklarasi DAO ----------------------------------------//
        GeneralDAO<Region> rdao = new GeneralDAO<>(sessionFactory, Region.class);
        GeneralDAO<Country> cdao = new GeneralDAO<>(sessionFactory, Country.class);
        GeneralDAO<Job> jdao = new GeneralDAO<>(sessionFactory, Job.class);
        IGeneralDAO<Department> igdao = new GeneralDAO<>(sessionFactory, Department.class);
        GeneralDAO<Location> ldao = new GeneralDAO<>(sessionFactory, Location.class);
        GeneralDAO<Employee> edao = new GeneralDAO<>(sessionFactory, Employee.class);
        GeneralDAO<Account> adao = new GeneralDAO<>(sessionFactory, Account.class);

        // ---------------------------------------- Testing  ----------------------------------------//       
        //Get By ID
//        Department department = igdao.getById(new Short("120"));
//        System.out.println(department.getId() + "\n" + department.getName());
//        System.out.println(department.getEmployee() == null ? "0" : department.getEmployee().getId());
//        System.out.println(department.getLocation().getId());
//        System.out.println("-----------------------------------");
        //Get Daata
//        for (Department d : igdao.getData("11")) {
//            System.out.println(d.getId()+ "\n" + d.getName());
//            System.out.println(d.getEmployee() == null ? "0" : d.getEmployee().getId());
//            System.out.println(d.getLocation().getId() + "\n");
//        }

        //SAVE OR DELETE
        System.out.println(igdao.saveOrDelete(new Department(new Short("301")),true));
        
        //DEPARTMENT END ------------------------------------------------------------------------
        
        /*   
        //Spesial aja
        
        //Lain-lain
        for (Region t : rdao.getAll()) {
            System.out.print(t.getId() + "  | ");
            System.out.println(t.getName()+ " | ");
        }
         */
        //Save ato Update ato Delete
/*      
        //Region
        System.out.println(rdao.saveOrDelete(new Region(new BigDecimal(11), "coba"), false));
        System.out.println(rdao.saveOrDelete(new Region (new BigDecimal(11), "cobaa"), false));
        System.out.println(rdao.saveOrDelete(new Region (new BigDecimal(11), "coba"), true));
         */

 /*
        //Country
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasa", new Region(new BigDecimal(11))), false));
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasaaa", new Region(new BigDecimal(11))), false));
        System.out.println(cdao.saveOrDelete(new Country("ad", "asasasa", new Region(new BigDecimal(11))), true));
         */
    }
}
