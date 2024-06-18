package org.example.pfrjks_jpl_practice_t03_kiennt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrescriptionDetailDTO {
    private int prescriptionId;
    private int drugId;
    private int quantity;
    private Date createdOn;

    @Override
    public String toString() {
        return "PrescriptionDetailDTO{" +
                "prescriptionId=" + prescriptionId +
                ", drugId=" + drugId +
                ", quantity=" + quantity +
                ", createdOn=" + createdOn +
                '}';
    }
}
