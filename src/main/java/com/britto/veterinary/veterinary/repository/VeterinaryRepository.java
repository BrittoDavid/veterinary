/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.UserDTO;
import static java.lang.Math.log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author britt
 */
@Repository
public class VeterinaryRepository {
    
    @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    public List<UserDTO> getUsersList() {

        System.out.println("[{}] AlertasRepository - getUsersList()");
        
        try {
            String sql = "SELECT * FROM user";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(UserDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getUsersList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getUsersList(), error: {} " + e);
        }
        
        return null;
    }
}
