/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.models;

import java.util.HashMap;

/**
 *
 * @author Алексей
 */
public class Basket extends HashMap<Integer, BasketItem>{
    public String getTotalCount(){
        
        double sum = 0.0;
        
        for(BasketItem item : this.values()){
            sum+= ( item.getCount() * item.getGood().getPrice());
        }//for
        
        return String.format("%.2f", sum);
        
    }
}
