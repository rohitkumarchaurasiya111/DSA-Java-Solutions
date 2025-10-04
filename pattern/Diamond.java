package pattern;

import java.util.*;

public class Diamond {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Lines(Even): ");
        int lines = scan.nextInt();
        if (lines % 2 != 0) {
            System.out.println("Not Even!");
            System.exit(0);
        }
        scan.close();
        for (int i = 1; i <= lines / 2; i++) {
            for (int j = lines / 2 - 1; j >= i; j--) {  // int j = 1; j<= lines/2 - i; j++ 
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) { 
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= lines / 2; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = lines - i; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
