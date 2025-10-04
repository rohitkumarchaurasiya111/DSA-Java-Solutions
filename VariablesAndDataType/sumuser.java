package VariablesAndDataType;
import java.util.*;

public class sumuser {
    public static void main(String args[]) {

        //Declaring scanner class
        Scanner scan = new Scanner(System.in);

        // for int
        System.out.print("Enter INTEGER Value: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int sum = a + b;
        System.out.print("Answer is: ");
        System.out.println(sum);

        //for boolean 
        System.out.print("Boolean Value: ");
        boolean answer = scan.nextBoolean();
        System.out.print("Answer is: ");
        System.out.println(answer);

        //for short 
        System.out.print("Short Value: ");
        short sh = scan.nextShort();
        System.out.print("Answer is: ");
        System.out.println(sh);

        // Product 
        System.out.print("Product of a and b: ");
        a = scan.nextInt();
        b = scan.nextInt();
        int product = a*b;
        System.out.print("Product is: ");
        System.out.println(product);

        // closing the scanner class
        scan.close();
    }
}
