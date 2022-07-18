/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service;

import com.britto.veterinary.veterinary.dto.EmployeeDTO;
import java.util.List;

/**
 *
 * @author britt
 */
public interface EmployeeService {
    public List<EmployeeDTO> getDataEmployee();
    public int addEmployee( EmployeeDTO employee);
    public int editEmployee(EmployeeDTO employee);
    public int deleteEmployee(int id);
}
