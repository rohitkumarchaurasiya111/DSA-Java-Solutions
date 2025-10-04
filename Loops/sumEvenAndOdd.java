package Loops;
import java.util.*;

public class sumEvenAndOdd {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int SumEven = 0;
        int SumOdd = 0;
        int num = 0;
        while (num!=-1) {
            System.out.print("Enter Number (-1 to Exit): ");
            num = scan.nextInt();
            if (num == -1) {
                break;
            }
            if (num % 2 == 0) {
                SumEven += num;
            } else {
                SumOdd += num;
            }

        }
        System.out.println("\nSum of Even Numbers is: " + SumEven);
        System.out.println("Sum of Odd Numbers is: " + SumOdd);
        scan.close();
    }
}
