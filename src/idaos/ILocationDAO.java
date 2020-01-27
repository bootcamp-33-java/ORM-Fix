/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Location;

/**
 *
 * @author HENSTECH
 */
public interface ILocationDAO {
//    mengambil data pada regions 
   public List<Location> getAll();
    
//    Method yang digunakan untuk dapat dan menyeleksi data dari table Location
    public Location getById (Short id);
    
    public List<Location> search(Object key);
    
    public boolean save(Location l);
    
 
   
   public boolean delete(Short id);
    
    
    
}