/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.models;
import java.util.*;

/**
 *
 * @author Алексей
 */
public class Order {
    
    private int id;
    private int userId;
    private Good good;
    private int amount;
    private double sum;
    
    public Order(int id, Integer userId, Good good, int amount, double sum) {
        this.id = id;
        this.userId = userId;
        this.good = good;
        this.amount = amount;
        this.sum = sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Good getGood() {
        return good;
    }

    public int getAmount() {
        return amount;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", good=" + good + ", amount=" + amount + ", sum=" + sum + '}';
    }

    
}
