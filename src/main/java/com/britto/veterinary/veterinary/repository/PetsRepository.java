/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.PetDTO;
import com.britto.veterinary.veterinary.dto.UserDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author britt
 */
@Repository
public class PetsRepository {
    @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    public List<PetDTO> getPetsList() {

        System.out.println("[{}] AlertasRepository - getPetsList()");
        
        try {
            String sql = "SELECT * FROM pet";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(PetDTO.class));            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getPetsList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getPetsList(), error: {} " + e);
        }
        
        return null;
    }
    
    
    public List<PetDTO> getPetsByuserid( int id) {

        System.out.println("[{}] AlertasRepository - getPetsByuserid()");
        
        try {
            String sql = "SELECT pet.*, user.name FROM pet INNER JOIN user ON pet.user_id = user.id WHERE user_id =" + id;

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(PetDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            throw new UnsupportedOperationException("Uff an error occurred while getting the pet");            
        } catch (Exception e) {
            throw new UnsupportedOperationException("Uff an error occurred while getting the pet");
        }             
    }
    
    public int deletePetById(int id){
        System.out.println("[{}] deletePetById()");        
        try {            
           return jdbcVeterinary.update("DELETE FROM pet WHERE id=?", id);
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: deletePetById(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while deleting the client");
        }catch(Exception e){
            System.out.println("[{}]Error: deletePetById(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while deleting the client"); 
        }       
    }
    
    public int insertPets(PetDTO pet){
        System.out.println("[{}] insertPets()");        
        try {
           return jdbcVeterinary.update("INSERT INTO pet (name, race, user_id, sex) VALUES(?,?,?,?)",
            new Object[] { pet.getName(), pet.getRace(), pet.getUser_id(),pet.getSex()});           
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: insertPets(), error: {} " + ce);
            throw new UnsupportedOperationException("Uff an error occurred while saving the pet");
        }catch(Exception e){
            System.out.println("[{}]Error: insertPets(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while saving the pet"); 
        }        
    }
    
    
}
