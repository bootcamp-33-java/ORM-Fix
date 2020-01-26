/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import controller.DepartmentController;
import icontroller.IDepartmentController;
import java.util.List;
import models.Department;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.HibernateUtil;

/**
 *
 * @author BWP
 */
public class JUnitTestDepartment {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    IDepartmentController idc = new DepartmentController(factory);

    public JUnitTestDepartment() {
    }
//    
//    @Test
//    public void testGetAll(){
//        List<Department> act = idc.getAll();
//        Assert.assertNotNull(act);
//    }
//    
//    @Test
//    public void testGetById(){
//        Department act = idc.getById("10");
//        Assert.assertNotNull(act);    
//    }
//    
    @Test
    public void save(){
        idc.save("300", "Agung lulusan terbaik", "107", "2400");
        Department d = idc.getById("300");
        Employee e = new Employee(107); //blum ada controllernya sementara
        Assert.assertEquals(new Short("300"), d.getDepartmentId());
        Assert.assertEquals("Agung lulusan terbaik", d.getDepartmentName());
        Assert.assertEquals("107", String.valueOf(e.getEmployeeId())); //sementara
        Assert.assertEquals(new Short("2400"), d.getLocationId().getLocationId());
    }
    
//    @Test
//    public void testDeleteById(){
//        String act = idc.delete("280");
//        Assert.assertEquals("Data berhasil dihapus",act);
//    }

}
