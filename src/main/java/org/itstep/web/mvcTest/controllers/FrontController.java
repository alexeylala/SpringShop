/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.controllers;

import java.sql.SQLException;
import java.util.List;
import org.itstep.web.mvcTest.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Алексей
 */
@Controller
@RequestMapping("/front")
@SessionAttributes(types = User.class)

public class FrontController {
    
    @RequestMapping(value="/start", method = RequestMethod.GET)
    public String start(ModelMap model) {

       return "index";
       
    }
    
    
     @RequestMapping(value = "/getSignIn", method = RequestMethod.GET)
    public String getSignIn(ModelMap model){
        
        return "signIn";
        
    }
}
