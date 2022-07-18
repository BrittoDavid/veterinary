/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.EmployeeDTO;
import com.britto.veterinary.veterinary.repository.EmployeeRepository;
import com.britto.veterinary.veterinary.repository.HistoryDetailsRepository;
import com.britto.veterinary.veterinary.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */
@Service
public class EmployeeServiceImlp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private HistoryDetailsRepository historyDetailsRepository;
    
    @Override
    public List<EmployeeDTO> getDataEmployee() {
        List<EmployeeDTO> employee = employeeRepository.getEmployeeList();        
        return employee;
    }        

    @Override
    public int addEmployee(EmployeeDTO employee) {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public int editEmployee(EmployeeDTO user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteEmployee(int id) {
        if (historyDetailsRepository.getHistoryDetailsByemployeeid(id).isEmpty()) {
            return employeeRepository.deleteEmployeeById(id);
        } else {
            return 0;
        }
    }
}
