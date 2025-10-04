package Loops;
import java.util.*;
public class sumofnnumbers {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number to get sum upto: ");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i+1;
        }
        System.out.println("The Sum is: " + sum);
        scan.close();
    }
}
