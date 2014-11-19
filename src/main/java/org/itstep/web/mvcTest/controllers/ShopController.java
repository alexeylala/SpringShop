/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itstep.web.mvcTest.models.Basket;
import org.itstep.web.mvcTest.models.BasketItem;
import org.itstep.web.mvcTest.models.Category;
import org.itstep.web.mvcTest.models.Good;
import org.itstep.web.mvcTest.models.User;
import org.itstep.web.mvcTest.services.GoodService;
import org.itstep.web.mvcTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/shop")
@SessionAttributes(types = Basket.class)
public class ShopController {
    @Autowired
    GoodService goodservice;
    UserService userService;
    
    @RequestMapping( method = RequestMethod.GET)
    public String categories(ModelMap model) {
        
        List<Category> cats;
        try {
            cats = goodservice.getCategoryList();
            model.addAttribute("cats", cats);
            
        }//try
        
        catch (SQLException ex) {
            return "NotFoundPage";
            
        }//catch
        
        return "categories";
        
    }//categories
    
    @RequestMapping(value = "/category/{id}",method = RequestMethod.GET)
    public String goods(
            @PathVariable(value = "id")
            Integer id,
            ModelMap model) {
        
        List<Good> goods;
        try {
            goods = goodservice.getList(id);
            model.addAttribute("goods", goods);
            return "seeAllGoods";
            
        }//try
        
        catch (SQLException ex) {
            
            return "NotFoundPage";
            
        }//catch
        
        
        
        
    }
    
    @RequestMapping(value = "/add/{categoryId}/{id}",method = RequestMethod.GET)
    public String add(
            @PathVariable(value = "categoryId")
            Integer catId,
            @PathVariable(value = "id")
            Integer id,
            ModelMap model) {
        
        Basket basket = (Basket) model.get("basket");
        if (basket == null) basket = new Basket();
        
        
        BasketItem i = basket.get(id);
        if (i == null) {
            
            i = new BasketItem();
            
            try {
                
                i.setGood(goodservice.find(id));
                
            }//try
            
            catch (SQLException ex) {
               return "NotFoundPage";
            }//catch
            
        } //if
        
        else {
            
            i.incCount();
            
        }//else

        basket.put(id, i);
        
        model.addAttribute("basket", basket);
        return "redirect:/shop/category/" + catId.toString();
    }
    
    
   @RequestMapping(value = "/remove/{id}",method = RequestMethod.GET)
    public String remove(
            @PathVariable(value = "id")
            Integer id,
            ModelMap model) {
        
        Basket basket = (Basket) model.get("basket");
        
        
        BasketItem i = basket.get(id);
        
        
        if(i.getCount() > 1){
            i.decCount();
            basket.replace(id, i);
        }//if
        else {
            basket.remove(id);
        }//else
        
        
        model.addAttribute("basket", basket);
        return "redirect:/good/getGoods/";
        
    }
    
    @RequestMapping(value = "/makeOrder/{userId}",method = RequestMethod.GET)
    public String makeOrder( 
            UsernamePasswordAuthenticationToken currentUser,
            @RequestParam(value = "userId")
            Integer id,
            ModelMap model){
        
            Basket basket = (Basket) model.get("basket");
            
            if(goodservice.confirmOrder(id, basket)){
                return "ConfirmOrder";
            }//if
            else
                return "error403";
         
        
    }
}