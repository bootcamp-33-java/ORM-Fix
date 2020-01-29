/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author HENSTECH
 */
public class LocationController implements ILocationController {

    private ILocationDAO ildao;

    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getAll();

    }

    @Override
    public Location getById(String id) {
        return ildao.getById(new Short(id));

    }

    @Override
    public List<Location> search(String key) {
         return ildao.search(key);

    }

    @Override
    public String save(String id, String streetAddress,
            String postalCode, String city, 
            String stateProvince, String countryId) {
        Location location = new Location(new Short(id), streetAddress,
                postalCode, city, stateProvince, new Country(countryId));
        if (ildao.save(location)) {
            return "Save Succes";

        } else {
            return "Save failed";
        }
    }

    @Override
    public String delete(String id) {
        if (ildao.delete(new Short(id))) {
            return "Delete Success";
        }
        return "Delete failed";
    }

}