/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.UserDTO;
import com.britto.veterinary.veterinary.repository.VeterinaryRepository;
import com.britto.veterinary.veterinary.service.VeterinaryService;
import java.util.List;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */

@Service
public class VeterinaryServiceImlp implements VeterinaryService{
    
    @Autowired
    private VeterinaryRepository veterinaryRepository;   

    @Override
    public List<UserDTO> getDataUsers() {
        List<UserDTO> users = veterinaryRepository.getUsersList();        
        return users;
    }
    
    

}
