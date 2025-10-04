package pattern;

import java.util.*;

public class solidrhombus {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Lines to Print: ");
        int lines = scan.nextInt();
        for (int i = 1; i <= lines; i++) {
            for (int j = lines; j >= i + 1; j--) { // int j=1; j<= lines-i ;j++
                System.out.print(" ");
            }
            for (int j = 1; j <= lines; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}
