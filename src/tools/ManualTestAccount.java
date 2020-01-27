/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.AccountDAO;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author yuyun
 */
public class ManualTestAccount {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(sessionFactory);
        System.out.println(HibernateUtil.getSessionFactory());

        AccountDAO adao=new AccountDAO(sessionFactory);
        
        // register 
        Account a=new Account(new Employee(207),"aqira","apasih");
        System.out.println(adao.register(a));
        
//        //login
//        System.out.println(adao.login("Yuyun", "apasih"));

           }
}
