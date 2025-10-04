package pattern;

import java.util.*;

public class characterpattern {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Lines to Print: ");
        int lines = scan.nextInt();
        // int count = 0;
        char ch = 'A';
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                // System.out.print((char)('A'+count));
                // count++;
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        scan.close();
    }
}
