package Function;

import java.util.*;

public class factorial {
    public static int Factorial(int num) {
        int fact = 1;
        while (num > 0) {
            fact *= num;
            num--;
        }
        return fact;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to find Factorial of: ");
        int num = scan.nextInt();
        int fact = Factorial(num);
        System.out.println("The Factorial of " + num + " is " + fact);
        scan.close();

    }
}
