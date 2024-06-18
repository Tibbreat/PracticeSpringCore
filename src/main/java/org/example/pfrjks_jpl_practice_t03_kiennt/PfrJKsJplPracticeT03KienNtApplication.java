package org.example.pfrjks_jpl_practice_t03_kiennt;


import org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager.DrugManager;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager.PrescriptionDetailManager;
import org.example.pfrjks_jpl_practice_t03_kiennt.dao.manager.PrescriptionManager;
import org.example.pfrjks_jpl_practice_t03_kiennt.utils.Constant;
import org.example.pfrjks_jpl_practice_t03_kiennt.utils.Validation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PfrJKsJplPracticeT03KienNtApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PfrJKsJplPracticeT03KienNtApplication.class, args);

        DrugManager drugManager = context.getBean(DrugManager.class);
        PrescriptionManager prescriptionManager = context.getBean(PrescriptionManager.class);
        PrescriptionDetailManager prescriptionDetailManager = context.getBean(PrescriptionDetailManager.class);
        Validation validation = new Validation();

        do {
            System.out.println("==== Prescription Management ====");
            System.out.println("1.Add Drug.");
            System.out.println("2.Add Prescription.");
            System.out.println("3.Add a list of Prescription Detail.");
            System.out.println("4.Calculate total for a Prescription.");
            System.out.println("5.Export a Prescription.");
            System.out.println("6.Delete a Prescription.");
            System.out.println("7.Close program.");
            int choice = validation.checkInputIntLimit(1, 7,
                    "Please choose function you'd like to do:",
                    "Enter in range 1 -> 7: ");
            switch (choice) {
                case 1:
                    boolean addDrug = drugManager.addDrug();
                    if (addDrug) {
                        System.out.println(Constant.ADD_SUCCESSFULLY);
                    } else {
                        System.out.println(Constant.ADD_FAILED);
                    }
                    break;
                case 2:
                    boolean addPrescription = prescriptionManager.saveOrUpdate();
                    if (addPrescription) {
                        System.out.println(Constant.ADD_SUCCESSFULLY);
                    } else {
                        System.out.println(Constant.ADD_FAILED);
                    }
                    break;
                case 3:
                    boolean addPrescriptionList = prescriptionDetailManager.addPrescriptionDetail();
                    if (addPrescriptionList) {
                        System.out.println(Constant.ADD_SUCCESSFULLY);
                    } else {
                        System.out.println(Constant.ADD_FAILED);
                    }
                    break;
                case 4:
                    boolean calculateAmount = prescriptionManager.updateTotalAmount();
                    if (calculateAmount) {
                        System.out.println(Constant.EDIT_SUCCESSFULLY);
                    } else {
                        System.out.println(Constant.EDIT_FAILED);
                    }
                    break;
                case 5:
                    boolean report = prescriptionManager.reportPrescription();
                    if (report) {
                        System.out.println(Constant.ADD_SUCCESSFULLY);
                    } else {
                        System.out.println(Constant.ADD_FAILED);
                    }
                    break;
            }
        } while (true);

    }
}
