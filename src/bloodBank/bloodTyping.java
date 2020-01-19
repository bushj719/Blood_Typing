package bloodBank;

import java.util.Scanner;

public class bloodTyping {
    public static void main(String[] args) {
        int frontA;
        int frontB;
        int rH;
        int control;
        int backA;
        int backB;
        String frontType = "";
        String backType = "";
        String bloodType = "";
        String rhType = "";
        Scanner keyboard = new Scanner (System.in);

        System.out.println("Please enter your grading results:");
        System.out.print("Anti-A: ");
        frontA = keyboard.nextInt();

        System.out.print("Anti-B: ");
        frontB = keyboard.nextInt();

        System.out.print("Anti-D: ");
        rH = keyboard.nextInt();

        System.out.print("Control: ");
        control = keyboard.nextInt();

        System.out.print("A1 cells: ");
        backA = keyboard.nextInt();

        System.out.print("B cells: ");
        backB = keyboard.nextInt();

        if (frontA >= 2 && frontB == 0) {
            frontType = "A";
        }
        if (frontA == 0 && frontB >= 2) {
            frontType = "B";
        }
        if (frontA == 0 && frontB == 0) {
            frontType = "O";
        }
        if (frontA >= 2 && frontB >= 2) {
            frontType = "AB";
        }
        if (frontA == 1 && frontB >= 2) {
            frontType = "AsubB";
        }
        if (frontA == 1) {
            frontType = "weakA";
        }
        if (backA == 0 && backB == 0) {
            backType = "AB";
        }
        if (backA >= 2 && backB == 0) {
            backType = "B";
        }
        if (backA == 0 && backB >= 2) {
            backType = "A";
        }
        if (backA >= 2 && backB >= 2) {
            backType = "O";
        }
        if (backA == 1 && backB == 0) {
            backType = "weakB";
        }
        if (backA == 0 && backB == 1) {
            backType = "weakA";
        }
        if (backA == 1 && backB == 1) {
            backType = "weakO";
        }
        if (backA == 1 && backB >= 2) {
            backType = "subA";
        }
        if (rH >= 1) {
            rhType = "Pos";
        }
        if (rH == 0) {
            rhType = "Neg";
        }
        if (control > 0) {
            bloodType = "invalid";
            System.out.println("Invalid test");
        }
        else if (frontType == backType) {
            bloodType = frontType;
            System.out.println(bloodType + " " + rhType);
        }
        else if (
                frontType.equals("A") && (backType.equals("AB") || backType.equals("weakA")) ||
                        frontType.equals("B") && (backType.equals("AB") || backType.equals("weakB")) ||
                                frontType.equals("O") && (backType.equals("AB") || backType.equals("weakA") || backType.equals("weakB"))
        )
        {
            bloodType = "Invalid blood type.  Possible weak back type";
            System.out.println(bloodType);
            System.out.println("Consider incubating backtype");
        }
        else if (
                ((frontType.equals("weakA")) && backType.equals("subA")) ||
                        (frontType.equals("AB") || frontType.equals("AsubB") && (backType.equals("B") || backType.equals("weakB")))
        ) {
            bloodType = "Invalid blood type.  Possible A sub type";
            System.out.println(bloodType);
            System.out.println("Consider Anti-A1 lectin testing");
        }
        else if (
                ((frontType.equals("A") || frontType.equals("B")) && (backType.equals("O"))) ||
                        (frontType.equals("AB") && (backType.equals("O") || backType.equals("weakO")))
        ) {
            bloodType = "Invalid blood type, possible interference from cold auto";
            System.out.println(bloodType);
            System.out.println("Consider incubating tube at 37 degrees C");
        }
    }
}
