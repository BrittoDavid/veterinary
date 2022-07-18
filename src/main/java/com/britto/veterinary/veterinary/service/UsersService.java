/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service;

import com.britto.veterinary.veterinary.dto.UserDTO;
import java.util.List;

/**
 *
 * @author britt
 */
public interface UsersService {
    public List<UserDTO> getDataUsers();
    public int addUser( UserDTO user);
    public int editUser(UserDTO user);
    public int deleteUser(int id);    
    
}
