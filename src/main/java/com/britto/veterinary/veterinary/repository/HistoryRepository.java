/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.HistoryDTO;
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
public class HistoryRepository {
    
    @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    public List<HistoryDTO> getHistoryList() {

        System.out.println("[{}] AlertasRepository - getHistoryList()");
        
        try {
            String sql = "SELECT history.*,pet.name FROM history INNER JOIN pet ON history.pet_id = pet.id";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryList(), error: {} " + e);
        }
        
        return null;
    }
    
    public int createHistory(HistoryDTO histo){
        System.out.println("[{}] createHistory()");        
        try {            
            return jdbcVeterinary.update("INSERT INTO history (pet_id) VALUES (?)",
            new Object[] {histo.getPet_id()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: createHistory(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the history");
        }catch(Exception e){
            System.out.println("[{}]Error: createHistory(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the history"); 
        }        
    }
    
    public int updateHistory(HistoryDTO histo){
        System.out.println("[{}] updateHisto()");        
        try {            
            return jdbcVeterinary.update("UPDATE history SET pet_id=? WHERE id=?",
            new Object[] { histo.getPet_id(), histo.getId()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: updateHisto(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the history");
        }catch(Exception e){
            System.out.println("[{}]Error: updateHisto(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the history"); 
        }        
    }
    
    
    public int deleteHistory(int id){
        System.out.println("[{}] deleteHistory()");        
        try {            
            return jdbcVeterinary.update("DELETE FROM history WHERE id=?", id);
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: deleteHistory(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the history");
        }catch(Exception e){
            System.out.println("[{}]Error: deleteHistory(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the history"); 
        }        
    }
    
    public List<HistoryDTO> getHistoryBypetid( int id) {

        System.out.println("[{}] AlertasRepository - getHistoryBypetid()");
        
        try {
            String sql = "SELECT history.*, pet.name FROM history INNER JOIN pet ON history.pet_id = pet.id WHERE history.pet_id =" + id;

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            throw new UnsupportedOperationException("Uff an error occurred while getting the history");            
        } catch (Exception e) {
            throw new UnsupportedOperationException("Uff an error occurred while getting the history");
        }            
    }
    
    
    
}
