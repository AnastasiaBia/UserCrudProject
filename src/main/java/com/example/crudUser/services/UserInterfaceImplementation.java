/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crudUser.services;

import com.example.crudUser.model.Users;
import com.example.crudUser.repositories.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Natasa
 */
@Service
@Transactional
public class UserInterfaceImplementation implements UserInterface {

    @Autowired
    UserRepository ur;


    @Override
    public void insertUser(Users u) {
        ur.save(u);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> result = (List<Users>) ur.findAll();
        
        return result;
    }

    @Override
    public Users getUserById(Integer id) {
    Users result = ur.findById(id).get();
        return result;
    }

    @Override
    public void updateUser(Users u) {
        ur.save(u);

    }

    @Override
    public void deleteUserById(Integer id) {
        ur.deleteById(id);
       
    }
    

}

