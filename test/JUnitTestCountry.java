
import controllers.CountryController;
import icontrollers.ICountryController;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import tools.HibernateUtil;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class JUnitTestCountry {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    ICountryController icc = new CountryController(factory);
    
    public JUnitTestCountry() {
    }

    @Test
    public void testGetById() {
        Country act = icc.getById("AR");
        Assert.assertNotNull(act);
    }
    @Test
    public void testGetAll() {
        List<Country> act3 = icc.getAll();
        Assert.assertNotNull(act3);
    }
    @Test
    public void testSearch() {
        List<Country> act2 = icc.search("1");
        Assert.assertNotNull(act2);
    }
    @Test
    public void testsave() {
        icc.save("OO", "NamaSaya", "2");
        Country c = icc.getById("OO");
        Assert.assertEquals("OO", c.getCountryId());
        Assert.assertEquals("NamaSaya", c.getCountryName());
        Assert.assertEquals(new BigDecimal("2"), c.getRegionId().getRegionId());

    }
    @Test
    public void testDelete() {
        String c = icc.delete("OO");
        Assert.assertEquals("Delete Success", c);
    }
    
}
