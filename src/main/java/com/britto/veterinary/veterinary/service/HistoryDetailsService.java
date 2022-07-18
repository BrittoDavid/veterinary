/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service;

import com.britto.veterinary.veterinary.dto.HistoryDetailDTO;
import java.util.List;

/**
 *
 * @author britt
 */
public interface HistoryDetailsService {
    public List<HistoryDetailDTO> getDataHistoryDetail();     
    public int editHistory(HistoryDetailDTO histo);
    public int addHistory( HistoryDetailDTO histo);    
    public int deleteHistory(int id);
    public List<HistoryDetailDTO> getDataHistoryDetailByhistoryid(int id);
}
