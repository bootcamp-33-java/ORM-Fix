/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Account;

/**
 *
 * @author yuyun
 */
public interface IAccountDAO {
    public boolean register(Account a);
    
    public boolean login(String username, String password);
}
