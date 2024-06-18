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
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String name;

    @Column(length = 1000)
    private String ingredients;

    private double unitPrice;
    private Date createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
}
