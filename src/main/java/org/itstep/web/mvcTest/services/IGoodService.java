/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.services;

import java.sql.SQLException;
import java.util.List;
import org.itstep.web.mvcTest.models.Basket;
import org.itstep.web.mvcTest.models.Category;
import org.itstep.web.mvcTest.models.Good;
import org.itstep.web.mvcTest.models.Order;
import org.itstep.web.mvcTest.models.User;

/**
 *
 * @author Алексей
 */
public interface IGoodService {

    boolean add(Good g) throws SQLException;

    boolean addOrder(Order order) throws SQLException;

    Good find(int id) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<Category> getCategoryList() throws SQLException;

    List<Good> getList(int categoryId) throws SQLException;

    List<Order> getListOfOrder(String userName) throws SQLException;
    
    boolean confirmOrder(Integer userId, Basket b);
    
}
