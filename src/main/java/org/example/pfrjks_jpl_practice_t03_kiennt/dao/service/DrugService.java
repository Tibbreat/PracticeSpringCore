package org.example.pfrjks_jpl_practice_t03_kiennt.dao.service;

import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    DrugRepo drugRepository;

    public Drug save(Drug drug) {
        return drugRepository.save(drug);
    }

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public Drug findDrugById(int id) {
        return drugRepository.findById(id).orElse(null);
    }
}
