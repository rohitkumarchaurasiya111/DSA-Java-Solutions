package Function;

import java.util.*;

public class palindrome {
    public static boolean palin(int a) {
        int rev = 0;
        int num = a;
        while (num > 0) {
            int lastDigit = num % 10;
            num = num / 10;
            rev = rev * 10 + lastDigit;
        }
        // System.out.println("REV IS " + rev);
        if (rev == a) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to check It is Palindrome: ");
        int num = scan.nextInt();
        if (palin(num)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        scan.close();
    }
}
