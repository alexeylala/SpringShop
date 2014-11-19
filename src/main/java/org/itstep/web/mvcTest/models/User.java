/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.web.mvcTest.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Алексей
 */
public class User implements UserDetails{
    
    private int id;
    private String login;
    private String password;
    private String email;
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
   
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + ", email=" + email + '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
           
        List<GrantedAuthority> roles = new ArrayList<>();
           roles.add(new GrantedAuthority() {

               @Override
               public String getAuthority() {
                   return "ROLE_USER";
               }
           });
           
           return roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
  return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}