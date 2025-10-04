package pattern;

import java.util.*;

public class halfPyramid {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Lines to print: ");
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
        scan.close();
    }
}
