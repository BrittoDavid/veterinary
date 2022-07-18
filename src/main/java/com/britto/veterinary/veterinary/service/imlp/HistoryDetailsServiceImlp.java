/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.HistoryDetailDTO;
import com.britto.veterinary.veterinary.repository.HistoryDetailsRepository;
import com.britto.veterinary.veterinary.service.HistoryDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */
@Service
public class HistoryDetailsServiceImlp implements HistoryDetailsService{
    @Autowired
    private HistoryDetailsRepository historyDetailsRepository;

    @Override
    public List<HistoryDetailDTO> getDataHistoryDetail() {
        try {
            List<HistoryDetailDTO> historyDetail = historyDetailsRepository.getHistoryDetailsList();
            return historyDetail;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unexpected error");
        }        
    }

    @Override
    public List<HistoryDetailDTO> getDataHistoryDetailByhistoryid(int id) {
        try {
            List<HistoryDetailDTO> historyDetailByhistoryID = historyDetailsRepository.getHistoryDetailsByhistoryid(id);
            return historyDetailByhistoryID;
        } catch (Exception e) {
            throw new Error("Unexpected error");
        }
    }
    
    @Override
    public int addHistory(HistoryDetailDTO histo) {
        return historyDetailsRepository.createHistory(histo);
    }
    
    @Override
    public int editHistory(HistoryDetailDTO histo) {
        return historyDetailsRepository.updateHistoryDetail(histo);
    }

    @Override
    public int deleteHistory(int id) {
        return historyDetailsRepository.deleteHistoryDetail(id);
    }
}
