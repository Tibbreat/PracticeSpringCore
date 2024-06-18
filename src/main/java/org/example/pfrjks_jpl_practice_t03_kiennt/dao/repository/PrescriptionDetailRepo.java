package org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository;

import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.PrescriptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionDetailRepo extends JpaRepository<PrescriptionDetail, Integer> {
    List<Drug> getDrugsByPrescriptionId(int prescriptionId);
}
