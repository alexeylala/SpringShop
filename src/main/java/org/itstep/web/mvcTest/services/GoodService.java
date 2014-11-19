/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.services;

/**
 *
 * @author Алексей
 */

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itstep.web.mvcTest.models.Basket;
import org.itstep.web.mvcTest.models.BasketItem;
import org.itstep.web.mvcTest.models.Category;
import org.itstep.web.mvcTest.models.Good;
import org.itstep.web.mvcTest.models.Order;
import org.itstep.web.mvcTest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "GoodService")
public class GoodService implements IGoodService {
    
    ResultSet goodServiceSet = null;
    @Autowired
    Connection connection = null;
    String query = null;
    PreparedStatement statement = null;

    public ResultSet getGoodsSet() {
        return goodServiceSet;
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
    
    @Override
    public List<Good> getList(int categoryId) throws SQLException{
        
        query = "SELECT * FROM goods WHERE categoryid = ?;";
        statement = connection.prepareStatement(query);
        
        statement.setInt(1, categoryId);
        goodServiceSet = statement.executeQuery();
        
        List<Good> goods = new ArrayList<>();
            
        while(goodServiceSet.next()){
            
            goods.add(new Good(
                    
                        goodServiceSet.getInt("id"),
                        goodServiceSet.getString("name"),
                        goodServiceSet.getString("description"),
                        goodServiceSet.getDouble("price"),
                        goodServiceSet.getInt("categoryid")
                    
                )//new Good
                    
            );// add
                
        }//while
            
        return goods;
     
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Category> getCategoryList() throws SQLException{
        
        query = "SELECT id, name FROM categories;";
        statement = connection.prepareStatement(query);
        
        goodServiceSet = statement.executeQuery();
        
        List<Category> categories = new ArrayList<>();
        
        while(goodServiceSet.next()){
            
            categories.add(
                    
                    new Category(
                            goodServiceSet.getInt("id"),
                            goodServiceSet.getString("name")
                    )//new Category
            );//add
        }//while
        
        return categories;
    }
    
    @Override
    public Good find(int id) throws SQLException{
        
        query = "SELECT * FROM goods WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        
        goodServiceSet = statement.executeQuery();
        
        if(goodServiceSet.next()){
            
            Good finded = new Good(
                    
                    goodServiceSet.getInt("id"),
                    goodServiceSet.getString("name"),
                    goodServiceSet.getString("description"),
                    goodServiceSet.getDouble("price"),
                    goodServiceSet.getInt("categoryid")
            );
            
            return finded;
            
        }//if
        
       return null;
    }//add
    
    @Override
    public boolean add(Good g) throws SQLException{
        
        //Проверка на наличие товара в БД
        
        query = "SELECT * FROM goods WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, g.getId());
        
        goodServiceSet = statement.executeQuery();
        
        if(goodServiceSet.next()){//Если товар есть то это модификация товара
            
            query = "UPDATE goods SET name = ?, description = ?, price = ?, categoryid = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, g.getName());
            statement.setString(2, g.getDescription());
            statement.setDouble(3, g.getPrice());
            statement.setInt(4, g.getCategoryId());
            statement.setInt(5, g.getId());
            
            return ( statement.executeUpdate() == 1);
            
        }//if
        
        
        query = "INSERT INTO goods(id,name,description,price,categoryid) VALUES(NULL,?,?,?,?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, g.getName());
        statement.setString(2, g.getDescription());
        statement.setDouble(3, g.getPrice());
        statement.setInt(4, g.getCategoryId());
        
        return ( statement.executeUpdate() == 1 );
        
        
    }//add
    
    @Override
    public boolean addOrder(Order order) throws SQLException{
            
        query = "INSERT INTO orders(id,userId,good,amount,sum) "
                + "VALUES(NULL,?,?,?,?)";
        
        statement = connection.prepareStatement(query);
        statement.setInt(1, order.getUserId());
        statement.setInt(2, order.getGood().getId());
        statement.setInt(3, order.getAmount());
        statement.setDouble(4, order.getSum());
        
        return (statement.executeUpdate() == 1);
        
    }//add order
    
    @Override
    public List<Order> getListOfOrder(String userName) throws SQLException{
        
            query = "SELECT * FROM orders WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            
            goodServiceSet = statement.executeQuery();
            
            List<Order> orders = new ArrayList<>();
            
            while(goodServiceSet.next()){
                
                Order o = new Order(
                        goodServiceSet.getInt("id"),
                        goodServiceSet.getInt("userId"), 
                        find(goodServiceSet.getInt("good")), 
                        goodServiceSet.getInt("amount"), 
                        goodServiceSet.getDouble("sum")
                );
                
                orders.add(o);
                
            }//while
            
            return orders;
            
    }//getListOfOrder
    
    @Override
    public boolean confirmOrder(Integer userId, Basket b){
        
        int i = 0;
        
        for (BasketItem bItem : b.values()) {
            
            int amount = bItem.getCount();
            double price = (bItem.getGood().getPrice() * amount);
            
            Order order = new Order(0, userId, bItem.getGood() , amount , price);
            
            try {
                
                addOrder(order);
                
            }//try 
            catch (SQLException ex) {
                return false;
            }//try
            
            i++;
            
        }//for
       
        
        return i == b.size();
        
    }
}
