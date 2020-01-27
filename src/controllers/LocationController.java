/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.LocationDAO;
import icontroller.ILocationController;
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

    private ILocationDAO ldao;

    public LocationController(SessionFactory factory) {
        ldao = new LocationDAO(factory);
    }

    @Override
    public List<Location> getAll() {
        return ldao.getAll();

    }

    @Override
    public Location getById(String id) {
        return ldao.getById(new Short(id));

    }

    @Override
    public List<Location> search(String key) {
         return ldao.search(key);

    }

    @Override
    public String save(String id, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        Location location = new Location(Short.parseShort(id), streetAddress, postalCode, city, stateProvince, new Country(countryId));
        if (ldao.save(location)) {
            return "Save Succes";

        } else {
            return "Save failed";
        }
    }

    @Override
    public String delete(String id) {
        if (ldao.delete(new Short(id))) {
            return "Delete Success";
        }
        return "Delete failed";
    }

}