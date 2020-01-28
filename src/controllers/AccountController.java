/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import icontrollers.IAccountController;
import idaos.IAccountDAO;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author yuyun
 */
public class AccountController implements IAccountController {

    private IAccountDAO iadao;

    public AccountController(SessionFactory factory) {
        iadao = new AccountDAO(factory);
    }

    @Override
    public String save(String accountId, String username, String password) {
        String pass= BCrypt.hashpw(password, BCrypt.gensalt());
        Account a = new Account(new Employee(Integer.parseInt(accountId)), username, pass);
        if (iadao.register(a)) {
            return "Data berhasil disimpan";
        } else {
            return "Data gagal disimpan";
        }

    }

    @Override
    public boolean login(String username, String password) {
        Account account=iadao.getByUsername(username);
        if (account != null && BCrypt.checkpw(password, account.getPassword())) {
            return true;
        }else{
            return false;
        }
    }

}
