/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import controllers.AccountController;
import daos.AccountDAO;
import icontrollers.IAccountController;
import idaos.IAccountDAO;
import models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import tools.HibernateUtil;

/**
 *
 * @author yuyun
 */
public class JUnitTestAccount {

    public JUnitTestAccount() {
    }
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    IAccountController iac = new AccountController(factory);
    IAccountDAO iadao = new AccountDAO(factory);

    @Test
    public void testRegister() {
        iac.save("207", "aqira", "apasih");
        Account a = iadao.getByUsername("aqira");
        Assert.assertEquals("aqira", a.getUsername());
//            
    }

    @Test
    public void testLogin() {

        Assert.assertTrue(iac.login("Yuyun", "apasih"));
    }
}
