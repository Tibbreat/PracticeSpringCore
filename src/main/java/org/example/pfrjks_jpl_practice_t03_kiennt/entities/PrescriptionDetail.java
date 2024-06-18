package org.example.pfrjks_jpl_practice_t03_kiennt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PrescriptionDetail {

    @EmbeddedId
    private PrescriptionDetailId id;
    private int quantity;
    private Date createdOn;

    @ManyToOne
    @MapsId("prescriptionId")
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @MapsId("drugId")
    @JoinColumn(name = "drug_id")
    private Drug drug;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}
