/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;

import java.util.List;
import models.Location;

/**
 *
 * @author FIKRI-PC
 */
public interface ILocationController {
    public List<Location> getAll();
    public Location getById(String id);
    public List<Location> search(String key);
    public String save(String id, String address, String postalCode, String city, String stateProvince, String countryId);
    public String delete(String id);
    
}
