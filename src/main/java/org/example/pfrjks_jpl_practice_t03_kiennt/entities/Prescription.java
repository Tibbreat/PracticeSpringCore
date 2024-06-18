package org.example.pfrjks_jpl_practice_t03_kiennt.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float totalAmount;
    private String doctorName;

    @Column(length = 50)
    private String patientName;

    private Date createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}

