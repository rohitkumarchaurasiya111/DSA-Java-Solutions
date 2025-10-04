package VariablesAndDataType;
import java.util.*;
public class areaofsquare {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Side of a Square: ");
        float side = scan.nextFloat();
        float area = side*side;
        System.out.print("The Area of Square is: ");
        System.out.println(area);
        scan.close();
    }
}
