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
public class HistoryDetailDTO {
    
    private Integer id;
    private String temperature;
    private String weight;
    private String heart_rate;
    private String breathing_frequency;
    private Date date_time;
    private String feeding;
    private String habitat;
    private String observacion;
    private Integer employee_id ;
    private Integer history_id ;
    //Name del empleado
    private String name;
    
}
