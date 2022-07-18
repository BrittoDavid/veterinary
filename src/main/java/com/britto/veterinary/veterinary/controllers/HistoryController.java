/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.controllers;

import com.britto.veterinary.veterinary.dto.HistoryDTO;
import com.britto.veterinary.veterinary.service.HistoryService;
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
@RequestMapping("history")
@CrossOrigin(origins="*", maxAge=3200)
public class HistoryController {
    
    @Autowired
    private HistoryService historyService; 
    
    @GetMapping("getHistory")
    public List<HistoryDTO> getHistory(){
        return this.historyService.getDataHistory();
    }
    
    @PostMapping("createHistory")
    public int createHistory(@RequestBody HistoryDTO histo){        
        return this.historyService.addHistory(histo);
    }
    
    
    @PutMapping("updateHistory")
    public int updateHistory(@RequestBody HistoryDTO histo){
        return this.historyService.editHistory(histo);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public int deleteHistory(@PathVariable("id") int id){
        return this.historyService.deleteHistory(id);
    }
    
    
}
