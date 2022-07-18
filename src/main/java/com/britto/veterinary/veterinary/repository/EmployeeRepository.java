/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.repository;

import com.britto.veterinary.veterinary.dto.EmployeeDTO;
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
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcVeterinary;
    
    public List<EmployeeDTO> getEmployeeList() {

        System.out.println("[{}] AlertasRepository - getEmployeeList()");
        
        try {
            String sql = "SELECT * FROM employee";

            return jdbcVeterinary.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(EmployeeDTO.class));
            
        } catch (CannotGetJdbcConnectionException ce) {
            System.out.println("[{}]Error: AlertasRepository - getEmployeeList(),error: {} " + ce);            
        } catch (Exception e) {
            System.out.println("[{}]Error: AlertasRepository - getEmployeeList(), error: {} " + e);
        }
        
        return null;
    }
    
    public int createEmployee(EmployeeDTO employee){
        System.out.println("[{}] createEmployee()");        
        try {            
            return jdbcVeterinary.update("INSERT INTO employee (name, last_name, position, specialy, document_type, number_document) VALUES (?,?,?,?,?,?)",
            new Object[] {employee.getName(),employee.getLast_name(),employee.getPosition(),employee.getSpecialy(),employee.getDocument_type(),employee.getNumber_document()});
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: createEmployee(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while inserting the employee");
        }catch(Exception e){
            System.out.println("[{}]Error: createEmployee(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while inserting the employee"); 
        }        
    }
    
    public int deleteEmployeeById(int id){
        System.out.println("[{}] deleteEmployeeById()");        
        try {            
           return jdbcVeterinary.update("DELETE FROM employee WHERE id=?", id);
        } catch (DataAccessException ce) {
            System.out.println("[{}]Error: deleteEmployeeById(), error: {} " + ce);
                throw new UnsupportedOperationException("Uff an error occurred while deleting the Employee");
        }catch(Exception e){
            System.out.println("[{}]Error: deleteEmployeeById(), error: {} " + e);
            throw new UnsupportedOperationException("Uff an error occurred while deleting the Employee"); 
        }       
    }
}
