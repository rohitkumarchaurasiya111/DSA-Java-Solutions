package Loops;
import java.util.*;

public class prime {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to check it is prime or not: ");
        int num = scan.nextInt();
        int check = 0;
        for (int i = 2; i*i <= num ; i++) // i<=Math.sqrt(n)
        {
            if (num % i == 0) {
                check = 1;
            }
        }
        if (check == 1) {
            System.out.print("The Number is: Not Prime!");
            System.exit(0);
        }
        System.out.println("The Number is: Prime!");
        scan.close();
    }
}
