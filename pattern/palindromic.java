package pattern;

import java.util.*;

public class palindromic {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Lines: ");
        int lines = scan.nextInt();
        scan.close();
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= lines - i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k > 0; k--) {
                System.out.print(k);
            }
            for (int k = 2; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }

    }
}
