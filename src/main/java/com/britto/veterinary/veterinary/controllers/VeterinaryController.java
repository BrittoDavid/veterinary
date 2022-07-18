    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.GenericDto;
import com.britto.veterinary.veterinary.dto.UserDTO;
import com.britto.veterinary.veterinary.service.VeterinaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britt
 */
@RestController
@RequestMapping("veterinary")
@CrossOrigin(origins="*", maxAge=3200)
public class VeterinaryController{
    
    @Autowired
    private VeterinaryService veterinaryService1;
   
//    @GetMapping("getUsers")
//    public ResponseEntity<GenericDto> getUsers() {        
//        return ResponseEntity.ok().body(GenericDto.sucess(this.veterinaryService1.getDataUsers()));
//    }
    
    @GetMapping("getUsers")
    public List<UserDTO> getUsers(){      
        return this.veterinaryService1.getDataUsers();
    }
    
    
}
