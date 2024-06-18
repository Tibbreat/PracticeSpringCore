package org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager;

import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.PrescriptionDetailService;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.PrescriptionService;
import org.example.pfrjks_jpl_practice_t03_kiennt.dto.PrescriptionDTO;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Prescription;
import org.example.pfrjks_jpl_practice_t03_kiennt.utils.Validation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class PrescriptionManager {
    @Autowired
    PrescriptionService prescriptionService;
    Validation validation = new Validation();
    @Autowired
    private PrescriptionDetailService prescriptionDetailService;

    public boolean saveOrUpdate() {
        Prescription prescription = Prescription.builder()
                .doctorName(validation.checkEmptyString("Enter doctor name: ", "Doctor name is required: "))
                .patientName(validation.checkEmptyString("Enter patient name: ", "Patient name is required: "))
                .build();
        return prescriptionService.saveOrUpdate(prescription) != null;
    }

    @Transactional
    public boolean updateTotalAmount() {
        int prescriptionId = validation.checkIntInput("Enter prescription id: ", "Prescription id is required: ");
        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);
        if (prescription == null) {
            System.out.println("Prescription not found");
            return false;
        } else {
            prescriptionService.updateTotalAmount(prescriptionId);
            return true;
        }
    }

    public boolean reportPrescription() {
        int prescriptionId = validation.checkIntInput("Enter prescription id: ", "Prescription id is required: ");
        Prescription prescription = prescriptionService.findPrescriptionById(prescriptionId);

        if (prescription == null) {
            System.out.println("Prescription not found");
            return false;
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Prescription_" + prescriptionId + ".dat"))) {
                PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
                BeanUtils.copyProperties(prescription, prescriptionDTO);
                writer.write("Prescription ID: " + prescriptionDTO.getId());
                writer.newLine();
                writer.write("Doctor Name: " + prescriptionDTO.getDoctorName());
                writer.newLine();
                writer.write("Patient Name: " + prescriptionDTO.getPatientName());
                writer.newLine();
                writer.write("Total Amount: " + prescriptionDTO.getTotalAmount());
                writer.newLine();
                writer.write("Created On: " + prescriptionDTO.getCreatedOn());
                writer.newLine();
                writer.write("Drug: " + prescriptionDetailService.getAllDrug(prescriptionId).toString());
                writer.newLine();
                writer.write("Calculated Total Amount: " + prescriptionService.calculateTotalAmount(prescriptionId));
                writer.newLine();

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
                return false;
            }
            return true;
        }
    }
}
