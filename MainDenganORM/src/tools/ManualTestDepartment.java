/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.DepartmentDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
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

        //GET ALL
//        List<Department> departments = ddao.getAll();
//        for (Department department : departments) {
//            System.out.println(department.getDepartmentId() +" = "+ department.getDepartmentName());
//        }
//        //GET ID
//        Department departments = ddao.getById(new Short("20"));
//        System.out.println(departments.getDepartmentId() + " = " + departments.getDepartmentName());

        //GET Search
        List<Department> departments = ddao.search("10");
        for (Department department : departments) {
            System.out.println(department.getDepartmentId() +" = "+ department.getDepartmentName());
        }
    }
}
