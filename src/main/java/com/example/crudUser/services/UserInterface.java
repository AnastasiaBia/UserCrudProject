/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crudUser.services;

import com.example.crudUser.model.Users;
import java.util.List;
import java.util.Optional;
import sun.security.krb5.Credentials;

/**
 *
 * @author Natasa
 */
public interface UserInterface {
     public void insertUser(Users u);
     
     public List<Users> getAllUsers();
     
     
     public Users getUserById(Integer id);
     
   public void updateUser(Users u);
   
   public void deleteUserById(Integer id);
   
 

}
