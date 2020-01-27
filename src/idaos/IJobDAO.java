/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author Insane
 */
public interface IJobDAO {
    public Job getById(String id);
    public List<Job> getAll();
    public List<Job> search(Object key);
    public boolean save(Job j);
    public boolean delete(String id);
    
}
