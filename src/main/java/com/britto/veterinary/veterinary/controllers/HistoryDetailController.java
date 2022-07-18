/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.HistoryDetailDTO;
import com.britto.veterinary.veterinary.service.HistoryDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britt
 */
@RestController
@RequestMapping("historyDetail")
@CrossOrigin(origins="*", maxAge=3200)
public class HistoryDetailController {
    @Autowired
    private HistoryDetailsService historyDetailService; 
    
    @GetMapping("getHistoryDetail")
    public List<HistoryDetailDTO> getHistoryDetail(){
        return this.historyDetailService.getDataHistoryDetail();
    }
    
    @GetMapping(path = {"/{id}"})
    public List<HistoryDetailDTO> getHistoryDetailByhistoryid(@PathVariable("id") int id){
        if (id <= 0) {
            throw new Error("Unexpected error");
        }else{
            return this.historyDetailService.getDataHistoryDetailByhistoryid(id);
        }       
    }
    
    @PostMapping("createHistoryDetail")
    public int createHistory(@RequestBody HistoryDetailDTO histo){        
        return this.historyDetailService.addHistory(histo);
    }
    
    
    @PutMapping("updateHistoryDetail")
    public int updateHistory(@RequestBody HistoryDetailDTO histo){
        return this.historyDetailService.editHistory(histo);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public int deleteHistory(@PathVariable("id") int id){
        return this.historyDetailService.deleteHistory(id);
    }
}
