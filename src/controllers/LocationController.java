/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.IGeneralDAO;
import idaos.ILocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author HENSTECH
 */
public class LocationController<T> implements ILocationController {

    private IGeneralDAO<Location> igdao;

    public LocationController(SessionFactory factory,Class<T> t) {
        igdao = new GeneralDAO<Location>(factory, Location.class);
    }

    @Override
    public List<Location> getAll() {
        return igdao.getData(null);

    }

    @Override
    public Location getById(String id) {
        return igdao.getById(new Short(id));

    }

    @Override
    public List<Location> search(String key) {
         return igdao.getData(key);

    }

    @Override
    public String save(String id, String streetAddress,
            String postalCode, String city, 
            String stateProvince, String countryId) {
        Location location = new Location(new Short(id), streetAddress,
                postalCode, city, stateProvince, new Country(countryId));
        if (igdao.saveOrDelete(location, false)) {
            return "Save Succes";

        } else {
            return "Save failed";
        }
    }

    @Override
    public String delete(String id) {
        Location location = new Location(new Short(id));
        if (igdao.saveOrDelete(location, true)) {
            return "Delete Success";
        }
        return "Delete failed";
    }

}