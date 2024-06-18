package org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository;

import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Integer> {

    Prescription findPrescriptionByDoctorNameAndAndPatientName(String doctorName, String patientName);

    @Modifying
    @Query("UPDATE Prescription p SET p.totalAmount = (SELECT SUM(pd.quantity * d.unitPrice) " +
            "FROM PrescriptionDetail pd JOIN pd.drug d WHERE pd.prescription.id = :prescriptionId) " +
            "WHERE p.id = :prescriptionId")
    void updateTotalAmountOfPrescription(@Param("prescriptionId") int prescriptionId);

    @Query("SELECT SUM(pd.quantity * d.unitPrice) FROM PrescriptionDetail pd JOIN pd.drug d WHERE pd.prescription.id = :prescriptionId")
    Double sumTotalAmountOfPrescription(@Param("prescriptionId") int prescriptionId);
}
