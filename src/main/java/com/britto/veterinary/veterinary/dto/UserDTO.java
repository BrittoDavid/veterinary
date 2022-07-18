/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.dto;

import lombok.Data;

/**
 *
 * @author britt
 */
@Data
public class UserDTO {
    
    private Integer id;
    private String name;
    private String last_name;
    private String document_type;
    private Integer identification_number;
    private String status;
    private String sex;
    
}
