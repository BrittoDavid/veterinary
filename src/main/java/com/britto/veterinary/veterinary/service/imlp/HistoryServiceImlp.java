/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.HistoryDTO;
import com.britto.veterinary.veterinary.repository.HistoryDetailsRepository;
import com.britto.veterinary.veterinary.repository.HistoryRepository;
import com.britto.veterinary.veterinary.service.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */
@Service
public class HistoryServiceImlp implements HistoryService{
    
    @Autowired
    private HistoryRepository historyRepository;
    
    @Autowired
    private HistoryDetailsRepository historyDetailsRepository;

    @Override
    public List<HistoryDTO> getDataHistory() {
        List<HistoryDTO> history = historyRepository.getHistoryList();
        return history;
    }
    
    @Override
    public int addHistory(HistoryDTO histo) {
        return historyRepository.createHistory(histo);
    }
    
    @Override
    public int editHistory(HistoryDTO histo) {
        return historyRepository.updateHistory(histo);
    }

    @Override
    public int deleteHistory(int id) {
        if (historyDetailsRepository.getHistoryDetailsByhistoryid(id).isEmpty()) {
           return historyRepository.deleteHistory(id);
        }else{
            return 0;
        }
    }
    
}
