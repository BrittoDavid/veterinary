/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author britt
 */

@Data
public class HistoryDTO {
    
    private Integer id;
    private Integer pet_id ;
    private Date date_creation;
    //Name de la mascota
    private String name;
}
