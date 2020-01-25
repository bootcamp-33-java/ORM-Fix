/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author aqira
 */
public class manualTest {

    /**
     * @param args the command line arguments
     */
    public void test(){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        System.out.println(factory);
        System.out.println(HibernateUtil.getSessionFactory());
    }
    public static void main(String[] args) {
        manualTest testing = new manualTest();
        testing.test();


}

}
