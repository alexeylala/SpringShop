/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.itstep.web.mvcTest.models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Алексей
 */
@Repository(value = "UserService")
public class UserService implements IUserService, UserDetailsService {
    
    private ResultSet userServiceSet = null;
    @Autowired
    private Connection connection = null;
    
    private String query = null;
    private PreparedStatement statement = null;

    public ResultSet getGoodServiceSet() {
        return userServiceSet;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getQuery() {
        return query;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setGoodServiceSet(ResultSet userServiceSet) {
        this.userServiceSet = userServiceSet;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }
    
    @Override
    public User findByName(String name) throws SQLException{
        
        User finededUser = null;
        
        query = "SELECT * FROM users WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        
        userServiceSet = statement.executeQuery();
        
        if(userServiceSet.next()){
            
            finededUser.setEmail(userServiceSet.getString("email"));
            finededUser.setPassword(userServiceSet.getString(userServiceSet.getString("password")));
            finededUser.setLogin(userServiceSet.getString("name"));
            finededUser.setIsAdmin(userServiceSet.getBoolean("isAdmin"));

        }//if
        
        return finededUser;
        
    }//findByName
    
    @Override
    public boolean authorize(String email, String password) throws SQLException{
        
        query = "SELECT * FROM users WHERE email = ? and password = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        
        userServiceSet = statement.executeQuery();
        
        if(userServiceSet.next()){
            
            return true;
            
        }
        else
            return false;
        
    }//authorize
    
    @Override
    public List<User> getUserList() throws SQLException{
        
        List<User> users = new ArrayList<>();
        
        query = "SELECT * FROM users";
        statement = connection.prepareStatement(query);
        
        userServiceSet = statement.executeQuery();
        
        while(userServiceSet.next()){
            
            User user = new User();
            
            user.setEmail(userServiceSet.getString("email"));
            user.setPassword(userServiceSet.getString("password"));
            user.setLogin(userServiceSet.getString("name"));
            user.setIsAdmin(userServiceSet.getBoolean("isAdmin"));
            
            users.add(user);//new User
            
        }//while
        
        if(users.size() > 0){
            return users;
        }
        else
            return null;
        
    }//getUserList
    
    @Override
    public User find(int id) throws SQLException{
        
        User finededUser = new User();
        
        query = "SELECT * FROM users WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        
        userServiceSet = statement.executeQuery();
        
        if(userServiceSet.next()){
            
            finededUser.setId(userServiceSet.getInt("id"));
            
            String password = userServiceSet.getString("password");
            finededUser.setPassword(password);
            finededUser.setEmail(userServiceSet.getString("email"));
            finededUser.setLogin(userServiceSet.getString("name"));
            finededUser.setIsAdmin(userServiceSet.getBoolean("isAdmin"));
            
        }//if
        
        return finededUser;
        
    }//find
    
    @Override
    public boolean add(User user) throws SQLException{
        
        query = "SELECT * FROM users WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, user.getId());
        userServiceSet = statement.executeQuery();
                
        if( userServiceSet.next()){//если id пользователя есть в БД то обновляем запись
            
            query = "UPDATE users SET name = ?, password = ?, email = ?, isAdmin = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setBoolean(4, user.isIsAdmin());
            statement.setInt(5, user.getId());
            
            return (statement.executeUpdate() == 1);
            
        }//if
        
        else{//Мы получили нового пользователя и добавляем его в БД
            
            query = "INSERT INTO users (name, email, password, isAdmin) VALUES (?, ? , ? ,?)";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setBoolean(4, user.isIsAdmin());
            
            return (statement.executeUpdate() == 1);
            
        }//else
        
    }//add
    
    @Override
    public boolean deleteUser(int id) throws SQLException{
        
        query = "DELETE FROM users WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        
        return (statement.executeUpdate() == 1);
        
    }

    @Override
    public UserDetails loadUserByUsername(String string)throws UsernameNotFoundException {
        
        User finededUser = new User();
        
        try{
            
            query = "SELECT * FROM users WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, string);

            userServiceSet = statement.executeQuery();

            if(userServiceSet.next()){

                finededUser.setId(userServiceSet.getInt("id"));
                finededUser.setEmail(userServiceSet.getString("email"));
                finededUser.setPassword(userServiceSet.getString("password"));
                finededUser.setLogin(userServiceSet.getString("name"));
                finededUser.setIsAdmin(userServiceSet.getBoolean("isAdmin"));

            }//if
            else{
                throw new UsernameNotFoundException("user not found");
            }
        }
        catch(SQLException ex){
            throw new UsernameNotFoundException("user not found");
        }
        
        return finededUser;
    }
    
}
