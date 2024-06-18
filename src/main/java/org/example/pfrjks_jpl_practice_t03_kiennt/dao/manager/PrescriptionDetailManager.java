package org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager;

import org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository.PrescriptionDetailRepo;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.DrugService;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.PrescriptionDetailService;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.PrescriptionService;
import org.example.pfrjks_jpl_practice_t03_kiennt.dto.DrugDTO;
import org.example.pfrjks_jpl_practice_t03_kiennt.dto.PrescriptionDTO;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Prescription;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.PrescriptionDetail;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.PrescriptionDetailId;
import org.example.pfrjks_jpl_practice_t03_kiennt.utils.Validation;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionDetailManager {

    @Autowired
    PrescriptionDetailService prescriptionDetailService;

    @Autowired
    DrugService drugService;

    @Autowired
    PrescriptionService prescriptionService;

    Validation validation = new Validation();
    @Autowired
    private PrescriptionDetailRepo prescriptionDetailRepo;

    @Transactional
    public boolean addPrescriptionDetail() {
        System.out.println("==List prescription==");
        List<Prescription> prescriptionList = prescriptionService.findAll();
        List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();
        for (Prescription prescription : prescriptionList) {
            PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
            BeanUtils.copyProperties(prescription, prescriptionDTO);
            prescriptionDTOList.add(prescriptionDTO);
        }
        prescriptionDTOList.forEach(System.out::println);


        int prescriptionId = validation.checkIntInput("Enter prescription id:  ", "Prescription is required: ");
        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);
        if (prescription == null) {
            System.out.println("Prescription not found!");
            return false;
        }

        System.out.println("==List drug==");
        List<Drug> drugList = drugService.getAllDrugs();
        List<DrugDTO> drugDTOList = new ArrayList<>();
        for (Drug drug : drugList) {
            DrugDTO drugDTO = new DrugDTO();
            BeanUtils.copyProperties(drug, drugDTO);
            drugDTOList.add(drugDTO);
        }
        drugDTOList.forEach(System.out::println);
        int drugId = validation.checkIntInput("Enter drug id: ", "Drug is required: ");


        Drug drug = drugService.findDrugById(drugId);
        if (drug == null) {
            System.out.println("Drug not found!");
            return false;
        }

        PrescriptionDetailId prescriptionDetailId = new PrescriptionDetailId(prescriptionId, drugId);
        PrescriptionDetail prescriptionDetail = PrescriptionDetail.builder()
                .id(prescriptionDetailId)
                .prescription(prescription)
                .drug(drug)
                .quantity(validation.checkIntInput("Enter drug quantity: ", "Drug quantity is required: "))
                .build();

        return prescriptionDetailService.addPrescriptionDetail(prescriptionDetail) != null;
    }

    List<Drug> getAllDrugs(int prescriptionId) {
     return prescriptionDetailService.getAllDrug(prescriptionId);
    }
}

