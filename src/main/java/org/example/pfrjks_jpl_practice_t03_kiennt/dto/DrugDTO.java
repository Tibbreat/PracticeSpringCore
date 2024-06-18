package org.example.pfrjks_jpl_practice_t03_kiennt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class DrugDTO {
    private int id;
    private String name;
    private String ingredients;

    private double unitPrice;
    private Date createdOn;

    @Override
    public String toString() {
        return "DrugDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", unitPrice=" + unitPrice +
                ", createdOn=" + createdOn +
                '}';
    }
}
