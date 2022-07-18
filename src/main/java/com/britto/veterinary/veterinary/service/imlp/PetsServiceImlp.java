/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.veterinary.veterinary.service.imlp;

import com.britto.veterinary.veterinary.dto.PetDTO;
import com.britto.veterinary.veterinary.repository.HistoryRepository;
import com.britto.veterinary.veterinary.repository.PetsRepository;
import com.britto.veterinary.veterinary.service.PetsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author britt
 */
@Service
public class PetsServiceImlp implements PetsService{

    @Autowired
    private PetsRepository petsRepository;
    
    @Autowired
    private HistoryRepository historyRepository;
    
    @Override
    public List<PetDTO> getDataPets() {
        List<PetDTO> pets = petsRepository.getPetsList();        
        return pets;
    }

    @Override
    public int addPet(PetDTO pet) {
        return petsRepository.insertPets(pet);
    }

    @Override
    public int editPet(PetDTO pet) {
        throw new UnsupportedOperationException("Unexpected error"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deletePet(int id) {
        if (historyRepository.getHistoryBypetid(id).isEmpty()) {
            return petsRepository.deletePetById(id);
        } else {
            return 0;
        }
    }
    
}
