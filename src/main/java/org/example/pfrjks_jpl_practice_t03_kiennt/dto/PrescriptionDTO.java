package org.example.pfrjks_jpl_practice_t03_kiennt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class PrescriptionDTO {
    private int id;
    private float totalAmount;
    private String doctorName;
    private String patientName;
    private Date createdOn;

    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
