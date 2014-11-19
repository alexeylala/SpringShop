/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.models;

/**
 *
 * @author Алексей
 */
public class BasketItem {
    int count = 1;
    Good good;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
    
    public int incCount() {
        return ++count;
    }
    
    public int decCount(){
        return --count;
    }
}
