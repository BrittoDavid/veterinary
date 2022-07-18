/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.EmployeeDTO;
import com.britto.veterinary.veterinary.service.EmployeeService;
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
@RequestMapping("employee")
@CrossOrigin(origins="*", maxAge=3200)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("getEmployee")
    public List<EmployeeDTO> getEmployee(){        
        return this.employeeService.getDataEmployee();
    }
    
    @PostMapping("createEmployee")
    public int createEmployee(@RequestBody EmployeeDTO employee){        
        return this.employeeService.addEmployee(employee);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public int deleteEmployee(@PathVariable("id") int id){
        return this.employeeService.deleteEmployee(id);
    }
}
