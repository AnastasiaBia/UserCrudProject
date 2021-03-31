/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crudUser.repositories;

import com.example.crudUser.model.Users;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Natasa
 */
public interface UserRepository extends CrudRepository <Users, Integer>{
    
   
}
