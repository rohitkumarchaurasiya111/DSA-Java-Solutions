package pattern;

import java.util.*;

public class triangle0_1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Lines: ");
        int lines = scan.nextInt();
        scan.close();
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        System.out.print("0 ");
                    } else {
                        System.out.print("1 ");
                    }
                } else {
                    if (j % 2 == 0) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }

                }
            }
            System.out.println();
        }
    }
}
