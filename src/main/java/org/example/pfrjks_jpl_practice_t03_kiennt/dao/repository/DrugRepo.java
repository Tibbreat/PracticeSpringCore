package org.example.pfrjks_jpl_practice_t03_kiennt.dao.repository;

import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepo extends JpaRepository<Drug, Integer> {
}
