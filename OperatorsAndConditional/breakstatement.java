package OperatorsAndConditional;
import java.util.*;

public class breakstatement {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter values: ");
            int num = scan.nextInt();
            if (num % 10 == 0) {
                break;
            }
            System.out.println(num);
        } while (true);
        System.out.println("Out of the Loop!");
        scan.close();
    }
}
