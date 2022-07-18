/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.HistoryDetailDTO;
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
public class HistoryDetailsRepository {
    
     @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    public List<HistoryDetailDTO> getHistoryDetailsList() {

        System.out.println("[{}] getHistoryDetailsList()");
        
        try {
            String sql = "SELECT history_detail.*, employee.name FROM history_detail INNER JOIN employee ON history_detail.employee_id = employee.id";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryDetailDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsList(), error: {} " + e);
        }
        
        return null;
    }
    
    public List<HistoryDetailDTO> getHistoryDetailsByhistoryid( int id) {

        System.out.println("[{}] AlertasRepository - getHistoryDetailsList()");
        
        try {
            String sql = "SELECT history_detail.*, employee.name FROM history_detail INNER JOIN employee ON history_detail.employee_id = employee.id WHERE history_id =" + id;

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryDetailDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsList(), error: {} " + e);
        }
        
        return null;
    }
    
    public List<HistoryDetailDTO> getHistoryDetailsByemployeeid( int id) {

        System.out.println("[{}] AlertasRepository - getHistoryDetailsByemployeeid()");
        
        try {
                String sql = "SELECT history_detail.*, employee.name FROM history_detail INNER JOIN employee ON history_detail.employee_id = employee.id WHERE history_detail.employee_id =" + id;

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryDetailDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsByemployeeid(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getHistoryDetailsByemployeeid(), error: {} " + e);
        }
        
        return null;
    }
    
    
    public int deleteHistoryDetail(int id){
        System.out.println("[{}] deleteHistoryDetail()");        
        try {            
            return jdbcVeterinary.update("DELETE FROM history_detail WHERE id=?", id);
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: deleteHistoryDetail(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the historyDetail");
        }catch(Exception e){
            System.out.println("[{}]Error: deleteHistoryDetail(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the historyDetail"); 
        }        
    }
    
    public int createHistory(HistoryDetailDTO histo){
        System.out.println("[{}] createHistoryDetail()");        
        try {            
            return jdbcVeterinary.update("INSERT INTO history_detail (temperature, weight, heart_rate, breathing_frequency, feeding, habitat, observacion, employee_id, history_id) VALUES (?,?,?,?,?,?,?,?,?)",
            new Object[] {histo.getTemperature(),histo.getWeight(),histo.getHeart_rate(),histo.getBreathing_frequency(),histo.getFeeding(),histo.getHabitat(),histo.getObservacion(),histo.getEmployee_id(),histo.getHistory_id()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: createHistoryDetail(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while creating the historyDetail");
        }catch(Exception e){
            System.out.println("[{}]Error: createHistoryDetail(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while creating the historyDetail"); 
        }        
    }
    
    public int updateHistoryDetail(HistoryDetailDTO histo){
        System.out.println("[{}] updateHistoryDetail()");        
        try {            
            return jdbcVeterinary.update("UPDATE history_detail SET temperature=?,weight=?,heart_rate=?,breathing_frequency=?,feeding=?,habitat=?,observacion=?,employee_id=?,history_id=? WHERE id=?",
            new Object[] { histo.getTemperature(),histo.getWeight(),histo.getHeart_rate(),histo.getBreathing_frequency(),histo.getFeeding(),histo.getHabitat(),histo.getObservacion(),histo.getEmployee_id(),histo.getHistory_id(),histo.getId()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: updateHistoryDetail(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while updating the historyDetail");
        }catch(Exception e){
            System.out.println("[{}]Error: updateHistoryDetail(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while updating the historyDetail"); 
        }        
    }
    
}
