package pattern;

import java.util.*;

public class invertedhalfpyramid {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter lines: ");
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines - i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
        scan.close();
    }
}
