package org.example.pfrjks_jpl_practice_t03_kiennt.dao.service;

import org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository.PrescriptionDetailRepo;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.PrescriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionDetailService {
    @Autowired
    PrescriptionDetailRepo prescriptionDetailRepo;

    public PrescriptionDetail addPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        return prescriptionDetailRepo.save(prescriptionDetail);
    }
    public List<Drug> getAllDrug(int prescriptionId){
        return prescriptionDetailRepo.getDrugsByPrescriptionId(prescriptionId);
    }
}
