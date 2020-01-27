/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import daos.JobDAO;
import daos.RegionDAO;
import idaos.IJobDAO;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import models.Job;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tools.HibernateUtil;

/**
 *
 * @author Insane
 */
public class manualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        System.out.println(factory);
        System.out.println(HibernateUtil.getSessionFactory());
        RegionDAO rdao = new RegionDAO(factory);
        IJobDAO jdao = new JobDAO(factory);

//        List<Region> regions = rdao.getAll();
//        for (Region region : regions) {
//            System.out.println(region.getRegionId());
//            System.out.println(region.getRegionName());
//        } // maggil getAll

//        rdao.getById(BigDecimal.valueOf(1)); //manggil getById Region
//        
//        System.out.println(jdao.getById("AD_PRES")); //getById Job SUCCESS
//        System.out.println(jdao.search("AD_PRES")); //SEARCH JOB SUCCESS

//        Job j = new Job("IT_Help","Help Desk",8200,16000); SAVE Job SUCCESS
//        System.out.println(jdao.save(j));
        
//        jdao.save(j);
        
//        System.out.println(jdao.delete("IT_Help")); //DELETE JOB SUCCESS

//        System.out.println(rdao.delete(1));
//        System.out.println(rdao.getById(BigDecimal.valueOf(1)));
        
//        List<Job> jobs = jdao.getAll();
//        for (Job job : jobs) {
//            System.out.println(job.getJobTitle());
//            System.out.println(job.getMinSalary());
//            System.out.println(job.getMaxSalary());
//        }
//        session.close();

    }

}
