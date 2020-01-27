/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author BWP
 */
public class DepartmentController implements IDepartmentController{

    private IDepartmentDAO iddao;

    public DepartmentController(SessionFactory factory) {
        iddao = new DepartmentDAO(factory);
    }

    @Override
    public List<Department> getAll() {
        return iddao.getAll();
    }

    @Override
    public Department getById(String id) {
        return iddao.getById(new Short(id));
    }

    @Override
    public List<Department> search(Object key) {
        return iddao.search(key);
    }

    @Override
    public String save(String id, String name, String managerId, String locationId) { 
        Department department = new Department(new Short(id), name,new Employee(new Integer(managerId)) , new Location(new Short(locationId)));
        if(iddao.save(department)){
            return "Data berhasil disimpan";
        }else{
            return "Data tidak berhasil disimpan";
        }
    }

    @Override
    public String delete(String id) {
        if(iddao.delete(new Short(id))){
            return "Data berhasil dihapus";
        }else{
            return "Data gagal dihapus";
        }
    }
    
    
}
