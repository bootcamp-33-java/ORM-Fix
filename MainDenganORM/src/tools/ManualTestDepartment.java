/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.DepartmentDAO;
import daos.LocationDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author BWP
 */
public class ManualTestDepartment {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
//        System.out.println(factory);
//        System.out.println(HibernateUtil.getSessionFactory());
        DepartmentDAO ddao = new DepartmentDAO(factory);
//        LocationDAO ldao = new LocationDAO(factory);

        //GET ALL
//        List<Department> departments = ddao.getAll();
//        String hasil;
//        for (Department department : departments) {
//            System.out.println(department.getDepartmentId() + "\n" + department.getDepartmentName());
////            hasil = department.getManagerId().getEmployeeId().toString().isEmpty()? "null" :"y";
////            System.out.println(hasil);
//            System.out.println(department.getEmployeeList());
//            System.out.println(department.getLocationId());
//            System.out.println("-----------------------------------");
//        }
        
//        //GET ID
//        Department departments = ddao.getById(new Short("20"));
//        System.out.println(departments.getDepartmentId() + " = " + departments.getDepartmentName());

//        INSERT OR UPDATE
//        Employee employee = new Employee();
//        Location location = new Location();
//        employee.setEmployeeId(100);
//        employee.setManagerId(employee);
//        location.setLocationId(new Short("1700"));
//        Department department = new Department(new Short("290"),"Agung lulusan terbaik", employee.getManagerId(), location);
//        System.out.println(ddao.save(department));

//        GET Search 
//        for (Department department : ddao.search("acc")) {
//            System.out.println(department.getDepartmentId() + "\n" + department.getDepartmentName());
////            hasil = ;
////            System.out.println(hasil);
//            System.out.println(department.getManagerId());
//            System.out.println(department.getLocationId());
//            System.out.println("-----------------------------------");
//        }
//        
//        //DELETE
//        System.out.println(ddao.delete(new Short("280")));


        session.close();
    }
}
