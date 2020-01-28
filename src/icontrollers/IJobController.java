/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author Insane
 */
public interface IJobController {
    public Job getById(String id);
    public List<Job> getAll();
    public List<Job> search(Object key);
    public String save(String id, String title, String min, String max);
    public String delete(String id);
    
}
