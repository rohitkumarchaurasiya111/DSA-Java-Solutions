package Loops;

import java.util.*;

public class factorial {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to get Factorial of: ");
        int num = scan.nextInt();
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        System.out.println("The Factorial of " + num + " is " + fact);
        scan.close();
    }
}
