package pattern;

import java.util.*;

public class Invertedstar {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many Lines: ");
        int lines = scan.nextInt();
        for (int i = lines; i > 0; i--) { //for(int i=1; i<=lines;i++)
            for (int j = i; j > 0; j--) { //for(int j=1; j<=lines-i+1; j++)
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}
