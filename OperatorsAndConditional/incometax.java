package OperatorsAndConditional;
import java.util.*;

public class incometax {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Income: ");
        int income = scan.nextInt();
        if (income < 500000) {
            System.out.println("No Income Tax!");
        } else if (income >= 500000 && income <= 1000000) {
            System.out.print("Your Income tax is: " + (float) income * 0.2);
        } else {
            System.out.print("Your Income tax is: " + (float) income * 0.3);
        }
        scan.close();
    }
}