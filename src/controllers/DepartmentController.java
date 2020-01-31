/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import daos.GeneralDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author BWP
 */
public class DepartmentController<T> implements IDepartmentController {

    private IGeneralDAO<Department> igdao;
    //= new GeneralDAO<>(sessionFactory, Department.class);

    public DepartmentController(SessionFactory sessionFactory, Class<T> t) {
        igdao = new GeneralDAO(sessionFactory, t);
    }

    @Override
    public List<Department> getAll() {
        return igdao.getData(null);
    }

    @Override
    public Department getById(String id) {
        return igdao.getById(new Short(id));
    }

    @Override
    public List<Department> search(Object key) {
        return igdao.getData(key);
    }

    @Override
    public String save(String id, String name, String managerId, String locationId) {
        Department department = new Department(new Short(id), name, new Employee(new Integer(managerId)), new Location(new Short(locationId)));
        if (igdao.saveOrDelete(department, false)) {
            return "Data berhasil disimpan";
        } else {
            return "Data tidak berhasil disimpan";
        }
    }

    @Override
    public String delete(String id) {
        Department department = new Department(new Short(id));
        if(igdao.saveOrDelete(department, true)){
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }
}
