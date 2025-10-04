package pattern;

import java.util.*;

public class hollowrhombus {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter lines: ");
        int lines = scan.nextInt();
        scan.close();
        for (int i = 1; i <= lines - 1; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= lines; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i <= lines - 2; i++) {
            for (int j = lines - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j <= lines - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 1; i <= lines; i++) {
            System.out.print("*");
        }
    }
}
