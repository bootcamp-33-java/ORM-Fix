/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author aqira
 */
public class RegionControllerJadi {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private IGeneralDAO gdao = new GeneralDAO<>(sessionFactory, Region.class);

    public RegionControllerJadi(SessionFactory sessionFactory) {
        gdao = new GeneralDAO(sessionFactory, Region.class) {
        };
    }

    public List<Region> getAll() {
        return gdao.getAll();
    }

//    public Region getById(String id) {
//        return gdao.getById(new BigDecimal(id));
//    }

    public List<Region> search(Object key) {
        return gdao.search(key);
    }

    public String save(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (gdao.saveOrDelete(region, false)) {
            return "Insert success";
        } else {
            return "Insert failed";
        }
    }

    public String delete(String id) {
        if (gdao.saveOrDelete(new BigDecimal(id), true)) {
            return "Delete Success";
        } else {
            return "Delete Failed";
        }
    }
}
