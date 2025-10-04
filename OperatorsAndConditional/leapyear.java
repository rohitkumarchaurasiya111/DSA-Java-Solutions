package OperatorsAndConditional;
import java.util.*;

public class leapyear {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Year: ");
        int year = scan.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Leap Year!");
                } else {
                    System.out.println("Not Leap Year!");
                }
            } else {
                System.out.println("Leap Year!");
            }
        } else {
            System.out.println("Not Leap Year!");
        }
        scan.close();
    }
}