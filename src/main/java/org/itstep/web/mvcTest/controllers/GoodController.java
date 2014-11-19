/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.controllers;

import java.sql.SQLException;
import java.util.List;
import org.itstep.web.mvcTest.models.Good;
import org.itstep.web.mvcTest.services.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Алексей
 */
@Controller
@RequestMapping("/good")
public class GoodController {
    
    @Autowired
    IGoodService goodService;
    
    @RequestMapping(value = "/getGoods",method = RequestMethod.GET)
    public String getGoods(ModelMap model ) throws SQLException{
        
        
        List<Good> goods = goodService.getList(7);
        model.addAttribute("goods", goods);
        
        return "seeAllGoods";
        
    }
}
