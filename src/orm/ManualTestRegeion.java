/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import daos.RegionDAO;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author aqira
 */
public class ManualTestRegeion {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    IRegionDAO irdao = new RegionDAO(sessionFactory);

    /**
     * @param args the command line arguments
     */
    public void test() {

        //       System.out.println(sessionFactory);
        System.out.println(HibernateUtil.getSessionFactory());
    }

    public void testGetById() {

        Region region = irdao.getById(new BigDecimal("1"));
        System.out.print(region.getRegionId() + "  | ");
        System.out.println(region.getRegionName() + " |  ");

    }

    public void testGetAll() {

        for (Region region : irdao.getAll()) {
            System.out.print(region.getRegionId() + "  | ");
            System.out.println(region.getRegionName() + " |  ");
        }
    }

    public void testSearch() {

        for (Region region : irdao.search("a")) {
            System.out.print(region.getRegionId() + "  | ");
            System.out.println(region.getRegionName() + " |  ");
        }
    }

    public void testSave() {
        Region region = new Region(new BigDecimal("11"),"coba");
        System.out.println(irdao.save(region));
    }
    
    public void testDelete() {
        System.out.println(irdao.delete(new BigDecimal("11")));
    }

    public static void main(String[] args) {

        ManualTestRegeion testing = new ManualTestRegeion();
//        testing.testGetById();
        testing.testGetAll();
//        testing.testSearch();
//        testing.testSave();
//        testing.testDelete();
    }

}
