/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service;

import com.britto.veterinary.veterinary.dto.HistoryDTO;
import java.util.List;

/**
 *
 * @author britt
 */
public interface HistoryService {
    public List<HistoryDTO> getDataHistory();
    public int editHistory(HistoryDTO histo);
    public int addHistory( HistoryDTO histo);    
    public int deleteHistory(int id);
}
