package org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager;

import org.example.pfrjks_jpl_practice_t03_kiennt.dao.service.DrugService;
import org.example.pfrjks_jpl_practice_t03_kiennt.entities.Drug;
import org.example.pfrjks_jpl_practice_t03_kiennt.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugManager {
    @Autowired
    DrugService drugService;

    Validation validation = new Validation();

    public boolean addDrug() {
        Drug drug = drugService.save(Drug.builder()
                .name(validation.checkEmptyString("Enter drug name: ", "Drug name is required: "))
                .ingredients(validation.checkEmptyString("Enter ingredients: ", "Ingredient list is required: "))
                .unitPrice(validation.checkDoubleInput("Enter drug price: ", "Drug price is required: "))
                .build());
        return drug != null;
    }
}
