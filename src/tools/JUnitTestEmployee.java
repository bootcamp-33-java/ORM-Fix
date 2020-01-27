/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import icontrollers.IEmployeeController;
import java.text.ParseException;
import java.util.List;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author yuyun
 */
public class JUnitTestEmployee {
    public JUnitTestEmployee() {
    }
SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        IEmployeeController iec = new EmployeeController(factory);

    @Test
    public void testGetAll() {
        List<Employee> listEmployee = iec.getAll();
        Assert.assertNotNull(listEmployee);
    }
    @Test
    public void testSearch() {
        List<Employee> listSearch = iec.search("King");
        Assert.assertNotNull(listSearch);
    }
    @Test
     public void testSave()throws ParseException{
        iec.save("88","Boy", "William", "boyWil@gmail.com", "08344456", "12-02-2019","2000","0","10","200","ST_CLERK");
//    
//        Assert.assertEquals("Boy", m.getStreetAddress());
//        Assert.assertEquals("William", m.getPostalCode());
//        Assert.assertEquals("Manng", m.getCity());
//        Assert.assertEquals("Manng", m.getStateProvince());
//        Assert.assertEquals("JP", m.getCountryId().getCountryId());
    }
    @Test
     public void testDelete() {
        Assert.assertNull(iec.delete("80"));
    }
}
