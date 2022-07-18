/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.UserDTO;
import com.britto.veterinary.veterinary.repository.PetsRepository;
import com.britto.veterinary.veterinary.repository.UsersRepository;
import com.britto.veterinary.veterinary.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */
@Service
public class UsersServiceImlp implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private PetsRepository petsRepository;
    
    @Override
    public List<UserDTO> getDataUsers() {
        List<UserDTO> users = usersRepository.getUsersList();        
        return users;
    }

    @Override
    public int addUser(UserDTO user) {
        return usersRepository.insertUsers(user);
    }

    @Override
    public int editUser(UserDTO user) {
        return usersRepository.updateUsers(user);
    }

    @Override
    public int deleteUser(int id) {
        
        if(petsRepository.getPetsByuserid(id).isEmpty()){
            return usersRepository.deleteUsersById(id);
        }else{
            return 0;
        }
    }
}
