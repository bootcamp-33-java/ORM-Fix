/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.HibernateUtil;
import models.Region;
/**
 *
 * @author aqira
 */
public class JUnitTestRegion {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    IRegionController irc = new RegionController(sessionFactory);

    public JUnitTestRegion() {
    }

    @Test
    public void testGetById() {
        Region act = irc.getById("1");
        Assert.assertNotNull(act);
    }

    public void testGetAll() {
        List<Region> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }

    public void testSearch() {
        List<Region> act2 = irc.search("1");
        Assert.assertNotNull(act2);
    }

    public void testSave() {
        irc.save("111", "NamaSaya");
        Region m = irc.getById("111");
        Assert.assertEquals("111", m.getRegionId());
        Assert.assertEquals("NamaSaya", m.getRegionName());

    }

    public void TestSaveUpdate() {
        irc.save("111", "NamaSayaIni");
        Region m = irc.getById("111");
        Assert.assertEquals("111", m.getRegionId());
        Assert.assertEquals("NamaSayaIni",m.getRegionName());
    }

    public void testDelete() {
        irc.delete("111");
        Region m = irc.getById("111");
        Assert.assertNull("111", irc.getById("111"));
    }
}
