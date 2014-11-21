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
import org.itstep.web.mvcTest.models.User;
import org.itstep.web.mvcTest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author РђР»РµРєСЃРµР№
 */
@Controller
@RequestMapping("/users")
@SessionAttributes("current")
public class UserController {
    
    @Autowired
    IUserService userService;
    
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(ModelMap model ) throws SQLException{
        
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        
        return "SeeAllUsers";
        
    }
    
    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    public String authorize(Model model) throws SQLException{
            return "signIn";
    }
    
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String show(
            UsernamePasswordAuthenticationToken currentUser,
            @RequestParam(value = "id",required = true, defaultValue = "1")
            Integer id,
            Model model) {
        
        User u;
        
        try {
            
            u = userService.find(((User) currentUser.getPrincipal()).getId());
            model.addAttribute("user", u);
            model.addAttribute("current", (User) currentUser.getPrincipal());
            return "user";
        
        } //try
        
        catch (SQLException ex) {
            return "NotFoundPage";
        }//catch
        
    }//user
    
}
