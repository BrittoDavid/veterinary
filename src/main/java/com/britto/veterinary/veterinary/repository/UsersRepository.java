/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.UserDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author britt
 */
@Repository
public class UsersRepository{
    @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    private NamedParameterJdbcTemplate templateNamedParameter;
    
    public List<UserDTO> getUsersList() {

        System.out.println("[{}] getUsersList()");
        
        try {
            String sql = "SELECT * FROM user";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(UserDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: getUsersList(),error: {} " + ce);
            throw new UnsupportedOperationException("Uff an error occurred while saving the client");
        } catch (Exception e) {
            System.out.println("[{}]Error: getUsersList(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while saving the client");
        }
    }
    
    public int insertUsers(UserDTO user){
        System.out.println("[{}] insertUsers()");        
        try {             
           return jdbcVeterinary.update("INSERT INTO user (name, last_name, document_type, identification_number, status, sex) VALUES(?,?,?,?,?,?)",
            new Object[] { user.getName(), user.getLast_name(), user.getDocument_type(),user.getIdentification_number(),user.getStatus(),user.getSex()});           
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: insertUsers(), error: {} " + ce);
            throw new UnsupportedOperationException("Uff an error occurred while saving the client");
        }catch(Exception e){
            System.out.println("[{}]Error: insertUsers(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while saving the client"); 
        }        
    }
    
    public int updateUsers(UserDTO user){
        System.out.println("[{}] updateUsers()");        
        try {            
           return jdbcVeterinary.update("UPDATE user SET name=?, last_name=?, document_type=?, identification_number=?, status=?, sex=? WHERE id=?",
        new Object[] { user.getName(), user.getLast_name(), user.getDocument_type(),user.getIdentification_number(),user.getStatus(),user.getSex(), user.getId()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: updateUsers(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the client");
        }catch(Exception e){
            System.out.println("[{}]Error: updateUsers(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the client"); 
        }        
    }
    
    public int deleteUsersById(int id){
        System.out.println("[{}] deleteUsers()");        
        try {            
           return jdbcVeterinary.update("DELETE FROM user WHERE id=?", id);
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: deleteUsers(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while deleting the client");
        }catch(Exception e){
            System.out.println("[{}]Error: deleteUsers(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while deleting the client"); 
        }        
    }
    
    
}
