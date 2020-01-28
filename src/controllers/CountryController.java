/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Tutus
 */
public class CountryController implements ICountryController {

    private ICountryDAO cdao;

    public CountryController(SessionFactory factory) {
        cdao = new CountryDAO(factory);
    }

    @Override
    public Country getById(String id) {
       return cdao.getById(id);
    }

    @Override
    public List<Country> search(String keyword) {
        return cdao.search(keyword);
    }

    @Override
    public List<Country> getAll() {
        return cdao.getAll();
    }

    @Override
    public String save(String id, String name, String region) {
       Country country = new Country(id, name, new Region(new BigDecimal(region)));
        if (cdao.save(country)) {
            return "Insert succes";
        }else {
            return "Insert failed";
        }
    }

    @Override
    public String delete(String id) {
        if (cdao.delete(id)) {
            return "Delete Success";
        }else{
            return "Delete failed";
        }
   }

}
