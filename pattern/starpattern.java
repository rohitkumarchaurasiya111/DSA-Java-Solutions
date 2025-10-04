package pattern;

import java.util.*;

public class starpattern {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many lines: ");
        int lines = scan.nextInt();
        for (int i = 1; i <= lines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}
