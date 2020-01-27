/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Insane
 */
public class RegionController implements IRegionController {
    
    private IRegionDAO rdao;
    
    public RegionController(SessionFactory factory){
        rdao = new RegionDAO(factory);
    }

    @Override
    public Region getById(String id) {
        return rdao.getById(new BigDecimal(id));
    }

    @Override
    public List<Region> getAll() {
        return rdao.getAll();
    }

    @Override
    public List<Region> search(Object key) {
        return rdao.search(key);
    }

    @Override
    public String insert(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (rdao.insert(region)) {
            return "Insert Success";
        }else{
            return "Insert Failed";
        }
    }

    @Override
    public String update(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (rdao.insert(region)) {
            return "Update Success";
        }else{
            return "Update Failed";
        
        }
    }

    @Override
    public String delete(int id) {
        if (rdao.delete(id)) {
            return "Delete Success";
        }else{
            return "Delete Failed";
        }
    }
    
}
