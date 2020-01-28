/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Country;

/**
 *
 * @author ASUS
 */
public interface ICountryDAO {
    public List<Country> getAll();

    public Country getById(String id);

    public List<Country> search(String keyword);

//    public boolean insert(Country country);
//
//    public boolean update(Country country);
    
    public boolean save(Country country);

    public boolean delete(String id);
}
