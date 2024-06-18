package org.example.pfrjks_jpl_practice_t03_kiennt.dao.service;

import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Prescription;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionRepo prescriptionRepo;

    public Prescription saveOrUpdate(Prescription prescription) {
        Prescription prescriptionCheckExist = prescriptionRepo.findPrescriptionByDoctorNameAndAndPatientName(prescription.getDoctorName(), prescription.getPatientName());
        return prescriptionRepo.save(Objects.requireNonNullElse(prescriptionCheckExist, prescription));
    }

    public List<Prescription> findAll() {
        return prescriptionRepo.findAll();
    }

    public Prescription findPrescriptionById(int id) {
        return prescriptionRepo.findById(id).orElse(null);
    }

    public void updateTotalAmount(int prescriptionId) {
        prescriptionRepo.updateTotalAmountOfPrescription(prescriptionId);
    }

    public float calculateTotalAmount(int prescriptionId) {
        Double totalAmount = prescriptionRepo.sumTotalAmountOfPrescription(prescriptionId);
        return (totalAmount != null) ? totalAmount.floatValue() : 0.0f;
    }
}
