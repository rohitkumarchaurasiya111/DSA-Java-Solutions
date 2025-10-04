package Loops;
import java.util.*;

public class continuestatement {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input != -1) 
        {
            System.out.print("Enter Number: ");
            input = scan.nextInt();
            if (input % 10 == 0) {
                continue;
            }
            System.out.println("Your Number is: " + input);
        }
        scan.close();
    }
}
