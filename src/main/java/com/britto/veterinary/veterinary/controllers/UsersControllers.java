/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.UserDTO;
import com.britto.veterinary.veterinary.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britt
 */
@RestController
@RequestMapping("users")
@CrossOrigin(origins="*", maxAge=3200)
public class UsersControllers {
    @Autowired
    private UsersService usersService;   
    
    @GetMapping("getUsers")
    public List<UserDTO> getUsers(){        
        return this.usersService.getDataUsers();
    }
    
    @PostMapping("createUsers")
    public int createUser(@RequestBody UserDTO user){        
        return this.usersService.addUser(user);
    }
    
    @PutMapping("updateUsers")
    public int updateUser(@RequestBody UserDTO user){        
        return this.usersService.editUser(user);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public int deleteUser(@PathVariable("id") int id){
        return this.usersService.deleteUser(id);
    }
    
    
    
}
