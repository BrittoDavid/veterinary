/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author britt
 */

@Data
public class GenericDto {
    public int status;

    public static GenericDto sucess(Object data) {
        GenericDto genericDto = new GenericDto();
        genericDto.setStatus(HttpStatus.OK.value());
        return genericDto;
    }

    public static GenericDto failed(Object data) {
        GenericDto genericDto = new GenericDto();
        genericDto.setStatus(HttpStatus.UNAUTHORIZED.value());
        return genericDto;
    }
}
