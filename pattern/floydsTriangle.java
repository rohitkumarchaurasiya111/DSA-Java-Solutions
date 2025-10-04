package pattern;

import java.util.*;

public class floydsTriangle {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter lines: ");
        int lines = scan.nextInt();
        scan.close();
        int num = 1;
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
