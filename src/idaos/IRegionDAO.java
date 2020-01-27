/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Region;

/**
 *
 * @author Insane
 */
public interface IRegionDAO {
    public Region getById(BigDecimal id);
    public List<Region> getAll();
    public List<Region> search(Object key);
    public boolean insert(Region r);
    public boolean update(Region r);
    public boolean delete(int id);
    
}
