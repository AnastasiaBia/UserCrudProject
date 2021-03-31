/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crudUser.controllers;

import com.example.crudUser.model.Users;
import com.example.crudUser.services.UserInterface;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.krb5.Credentials;

/**
 *
 * @author Natasa
 */
@Controller
public class UserController {
    
@Autowired
    UserInterface ui;

//    Set startpage.jsp as default
    @GetMapping(value = "/")
    public String showStartPage() {

        return "startpage";
    }

    //Method to retrieve a list of all users and go to allusers.jsp
    @GetMapping(value = "/getallusers")
    public String fetchallusers(ModelMap mm) {

        List<Users> result = ui.getAllUsers();
        mm.addAttribute("olausers", result);
       
        return "allusers";
    }

    //Method to retrieve a list of all users and go to update users.jsp
    @GetMapping(value = "/updateusers")
    public String updateusers(ModelMap mm) {

        List<Users> result = ui.getAllUsers();
        mm.addAttribute("olausers", result);
        return "updateusers";
    }

    //Method to retrieve a list of all users and go to deleteusers.jsp
    @GetMapping(value = "/deleteusers")
    public String deleteusers(ModelMap mm) {

        List<Users> result = ui.getAllUsers();
        mm.addAttribute("olausers", result);
        return "deleteusers";
    }

    //Method to create a User before going to insertuserform.jsp
    @GetMapping(value = "/preinsertuser")
    public String preinsertUser(ModelMap mm) {
        Users u = new Users();
        mm.addAttribute("user", u); // This will go in modelAttribute in the form

        return "insertuserform";
    }

    //Method that gets the form posting and inserts user in database
    @PostMapping(value = "/insertuser")
    //Gets the user entity with  Modelattribute
    //BindingResult  stores all the data of the form that is connected with the Entity

    public String insertUser(@Valid @ModelAttribute("user") Users u, BindingResult br, ModelMap mm) {

        //ServerSide Validation 
        if (br.hasErrors()) {

            return "insertuserform";
        }
        ui.insertUser(u);

        return "startpage";
    }

    //Method to create a User before going to updateform.jsp
    @GetMapping(value = "preupdate/{id}")
    public String preupdate(@PathVariable(name = "id") Integer id,
            ModelMap mm) {

        mm.addAttribute("user", ui.getUserById(id));

        return "updateform";
    }

    //Method to create a User before going to deleteform.jsp
    @GetMapping(value = "predelete/{id}")
    public String predelete(@PathVariable(name = "id") Integer id,
            ModelMap mm) {

        mm.addAttribute("user", ui.getUserById(id));

        return "deleteform";
    }

    //Method that gets the form posting and updates user in database
    @PostMapping(value = "/updateuser")
    public String updateUser(ModelMap mm, @RequestParam(name = "userId") Integer userId, @RequestParam(name = "userName") String userName,
            @RequestParam(name = "userEmail") String userEmail, @RequestParam(name = "userCompany") String userCompany) {
        Users u = new Users();
        u.setUserId(userId);
        u.setUserName(userName);
        u.setUserEmail(userEmail);
        u.setUserCompany(userCompany);
        ui.updateUser(u);

        return "redirect: updateusers";
    }

    //Method that gets the form posting and deletes user in database
    @PostMapping(value = "/deleteuser")
    public String deleteUser(ModelMap mm, @RequestParam(name = "userId") Integer userId) {

        ui.deleteUserById(userId);

        return "redirect: deleteusers";
       
        
    }
    
    


}
