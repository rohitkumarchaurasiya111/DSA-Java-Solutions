package Loops;

import java.util.*;

public class Table {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to get Table of: ");
        int num = scan.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        scan.close();
    }
}
