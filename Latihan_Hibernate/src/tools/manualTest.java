/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import daos.RegionDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author yuyun
 */
public class manualTest {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(sessionFactory);
        System.out.println(HibernateUtil.getSessionFactory());

        RegionDAO rdao = new RegionDAO(sessionFactory);
        Region r = new Region(BigDecimal.valueOf(12), "Boy");
        System.out.println(rdao.insert(r));

        Department d = new Department();
        d.setDepartmentId(20);

        Job j = new Job();
        j.setJobId("AD_VP");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse("12-02-2019");
        EmployeeDAO edao = new EmployeeDAO(sessionFactory);
        //        //insert or update
        //        Employee em = new Employee(90, "Muhammad", "Nur Iqbal", "omBoyen@gmail.com", "08344456", date, BigDecimal.valueOf(20000), BigDecimal.valueOf(0), d, 200, j);
        //        System.out.println(edao.save(em));
        //     
        //        //delete
        //        System.out.println(edao.delete(90));
        //
        //        //getAll
        //        List<Employee> employees=edao.getAll();
        //        for (Employee e : employees) {
        //            System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName());
        //        }

        //        //getById
//                Employee e=edao.getById(90);
//                System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName());

                //getAll
                List<Employee> employees=edao.search("163");
                for (Employee e : employees) {
                    System.out.println(e.getEmployeeId()+" "+e.getFirstName()+" "+e.getLastName()+" "+
                                        e.getPhoneNumber()+" "+e.getSalary()+" "+e.getCommissionPct()+" "+e.getManagerId());
                }
    }
}
