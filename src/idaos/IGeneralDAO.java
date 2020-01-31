/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Region;

/**
 *
 * @author aqira
 */
public interface IGeneralDAO<T> {

    public T getById(Object key);
    public List<T> getData(Object key);
    boolean saveOrDelete(T t, boolean isDelete);


}
