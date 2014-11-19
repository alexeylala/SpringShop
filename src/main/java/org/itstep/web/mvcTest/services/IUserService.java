/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.services;

import java.sql.SQLException;
import java.util.List;
import org.itstep.web.mvcTest.models.User;

/**
 *
 * @author Алексей
 */
public interface IUserService {

    boolean add(User user) throws SQLException;

    boolean authorize(String name, String password) throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    User find(int id) throws SQLException;

    User findByName(String name) throws SQLException;

    List<User> getUserList() throws SQLException;
    
}
