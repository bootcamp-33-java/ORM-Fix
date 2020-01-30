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

    List<T> getAll();

    T getById(T t);

    boolean saveOrDelete(T t, boolean isDelete);

    List<T> search(T t);

}
