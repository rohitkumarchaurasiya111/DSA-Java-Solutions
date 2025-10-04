package Loops;
import java.util.*;

public class reverse {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to Reverse: ");
        int num = scan.nextInt();
        int reverse = 0;
        // int i = (int) Math.log10(num) + 1;
        while (num > 0) {
            // i--;
            int lastdigit = num % 10;
            num = num / 10;
            // reverse += lastdigit * (int) (Math.pow(10, i));
            reverse = (reverse * 10) + lastdigit;
        }
        System.out.println("Reverse value is: " + reverse);
        scan.close();
    }
}
