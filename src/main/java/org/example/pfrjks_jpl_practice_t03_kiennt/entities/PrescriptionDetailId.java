package org.example.pfrjks_jpl_practice_t03_kiennt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PrescriptionDetailId implements Serializable {
    private int prescriptionId;
    private int drugId;
}
