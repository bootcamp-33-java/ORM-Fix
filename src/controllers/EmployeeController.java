/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.GeneralDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author yuyun
 */
public class EmployeeController<T> implements IEmployeeController {

    private IGeneralDAO<Employee> igdao;

    public EmployeeController(SessionFactory sessionFactory, Class<T> t) {
        igdao = new GeneralDAO(sessionFactory, Employee.class);
    }
    
    @Override
    public Employee getById(String id) {
        return igdao.getById(Integer.parseInt(id));
    }

    @Override
    public List<Employee> getAll() {
        return igdao.getData(null);
    }

    @Override
    public List<Employee> search(String key) {
        return igdao.getData(key);
    }

    @Override
    public String delete(String id) {
//        if (igdao.saveOrDelete(,true)) {
//            return "Data Berhasil Dihapus";
//        } else {
//            return "Data Gagal Dihapus";
//        }
        return "a";
    }

    @Override
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate,
            String salary, String commissionPct, String managerId, String departmentId, String jobId) throws ParseException {

        //parsing string to date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(hireDate);

        Employee e = new Employee(Integer.parseInt(id), firstName, lastName, email, phoneNumber, date,
                new BigDecimal(salary), new BigDecimal(commissionPct), new Department(new Short(departmentId)),
                new Employee(Integer.parseInt(managerId)), new Job(jobId));

//        if (igdao.save(e)) {
//            return "Data Berhasil Disimpan";
//        } else {
//            return "Data Gagal Disimpan";
//        }
        return "a";
    }

}
