/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.text.ParseException;
import java.util.List;
import models.Employee;

/**
 *
 * @author yuyun
 */
public interface IEmployeeController {
    public List<Employee> getAll();

    public List<Employee> search(String key);
    
    public String save(String id, String firstName, String lastName, String email, String phoneNumber, 
            String hireDate, String salary, String commissionPct, String managerId, String departmentId, String jobId) throws ParseException;
    
    public String delete (String id);
}
