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
        Account a = new Account(new Employee(Integer.parseInt(accountId)), username, password);
        if (iadao.register(a)) {
            return "Data berhasil disimpan";
        } else {
            return "Data gagal disimpan";
        }

    }

    @Override
    public boolean login(String username, String password) {
        if (iadao.login(username, password)) {
            return true;
        }else{
            return false;
        }
    }

}
