/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Insane
 */
public class JobController implements IJobController{
    
    private IJobDAO jdao;
    
    public JobController(SessionFactory factory){
        jdao = new JobDAO(factory);
    }

    @Override
    public Job getById(String id) {
        return jdao.getById(id);
    }

    @Override
    public List<Job> getAll() {
        return jdao.getAll();
    }

    @Override
    public List<Job> search(Object key) {
        return jdao.search(key);
    }


    @Override
    public String delete(String id) {
        if (jdao.delete(id)) {
            return "Delete Success";
        }else{
            return "Delete Failed";
        }
    }

    @Override
    public String save(String id, String title, Integer min, Integer max) {
        String result = "";
        Job job = new Job(id, title, min, max);
        if (jdao.save(job)) {
            result = "Data Saved Successfull";
        } else {
            result = "Data Saved Failed";
        }
        return result;
    }
    
}
