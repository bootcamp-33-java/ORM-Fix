/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author Insane
 */
public interface IRegionController {
    public Region getById(String id);
    public List<Region> getAll();
    public List<Region> search(Object key);
    public String insert(String id, String name);
    public String update(String id, String name);
    public String delete(int id);
    
}
