package org.example.pfrjks_jpl_practice_t03_kiennt.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Validation {
    Scanner sc = new Scanner(System.in);


    public String checkEmptyString(String inMsg, String outMsg) {
        while (true) {
            System.out.print(inMsg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(outMsg);
            } else {
                return input;
            }
        }
    }

    public double checkDoubleInput(String inMsg, String outMsg) {
        while (true) {
            System.out.print(inMsg);
            try {
                double input = Double.parseDouble(sc.nextLine().trim());
                if (input <= 0) {
                    System.out.print(outMsg);
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.print(outMsg);
            }
        }
    }
    public int checkIntInput(String inMsg, String outMsg) {
        while (true) {
            System.out.print(inMsg);
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input <= 0) {
                    System.out.print(outMsg);
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.print(outMsg);
            }
        }
    }

    public int checkInputIntLimit(int min, int max, String inMsg, String outMsg) {

        while (true) {
            try {
                System.out.print(inMsg);
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println(outMsg);
            }
        }
    }
}
