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
 * @author aqira
 */
public class RegionController implements IRegionController {

    private IRegionDAO rdao;

    public RegionController(SessionFactory sessionFactory) {
        rdao = new RegionDAO(sessionFactory) {
        };
    }

    @Override
    public List<Region> getAll() {
        return rdao.getAll();
    }

    @Override
    public Region getById(String id) {
        return rdao.getById(new BigDecimal(id));
    }

    @Override
    public List<Region> search(Object key) {
        return rdao.search(key);
    }

    @Override
    public String insert(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (rdao.save(region)) {
            return "Insert success";
        } else {
            return "Insert failed";
        }
    }

    @Override
    public String update(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (rdao.save(region)) {
            return "Update Success";
        } else {
            return "Update Failed";
        }
    }

    @Override
    public String delete(String id) {
        if (rdao.delete(new BigDecimal(id))) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
        }
    }
