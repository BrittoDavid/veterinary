/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.PetDTO;
import com.britto.veterinary.veterinary.dto.UserDTO;
import com.britto.veterinary.veterinary.service.PetsService;
import com.britto.veterinary.veterinary.service.VeterinaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britt
 */
@RestController
@RequestMapping("pets")
@CrossOrigin(origins="*", maxAge=3200)
public class PetsControllers {
    @Autowired
    private PetsService petsService;   
    
    @GetMapping("getPets")
    public List<PetDTO> getPet(){        
        return this.petsService.getDataPets();
    }
    
    @PostMapping("createPet")
    public int createPet(@RequestBody PetDTO pet){        
        return this.petsService.addPet(pet);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public int deletePet(@PathVariable("id") int id){
        return this.petsService.deletePet(id);
    }
}
