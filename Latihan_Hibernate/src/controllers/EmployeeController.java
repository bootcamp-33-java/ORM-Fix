/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
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
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO iedao;
    

    public EmployeeController(SessionFactory factory) {
        iedao = new EmployeeDAO(factory);
    }

    @Override
    public List<Employee> getAll() {
        return iedao.getAll();
    }

    @Override
    public List<Employee> search(String key) {
        return iedao.search(key);
    }

    @Override
    public String delete(String id) {
        if (iedao.delete(Integer.parseInt(id))) {
            return "Data Berhasil Dihapus";
        } else {
            return "Data Gagal Dihapus";
        }
    }

    @Override
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, String hireDate,
            String salary, String commissionPct, String managerId, String departmentId, String jobId) throws ParseException {
        
        //parsing string to date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(hireDate);

        Employee e = new Employee(Integer.parseInt(id), firstName, lastName, email, phoneNumber, date, 
                new BigDecimal(salary), new BigDecimal(commissionPct), new Department(Integer.parseInt(departmentId)),
                new Employee(Integer.parseInt(managerId)), new Job(jobId));
        
        if (iedao.save(e)) {
            return "Data Berhasil Disimpan";
        } else {
            return "Data Gagal Disimpan";
        }
    }

}
