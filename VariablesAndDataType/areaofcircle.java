package VariablesAndDataType;
import java.util.*;
public class areaofcircle {
    public static void main(String args[])
    {
        Scanner scan =  new Scanner(System.in);
        System.out.print("Enter Radius: ");
        float rad = scan.nextFloat();
        float area = 3.14f * rad * rad;
        System.out.print("Area of Circle is: ");
        System.out.println(area);
        scan.close();
    }
}
