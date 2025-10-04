package pattern;

import java.util.*;

public class Invertedandrotatedhalfpyramid {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter lines to print: ");
        int lines = scan.nextInt();
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= lines - i; j++) {
                System.out.print(" ");
            }
            for (int k = lines - i + 1; k <= lines; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}
