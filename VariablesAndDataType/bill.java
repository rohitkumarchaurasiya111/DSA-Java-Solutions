package VariablesAndDataType;
//Entercostof3itemsfromtheuser(usingfloatdatatype)-apencil,apenandan eraser. You have to output the total cost of the items back to the user as their bill.(Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)
import java.util.*;
public class bill {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the cost of Pen: ");
        float pen = scan.nextFloat();
        System.out.print("Enter the cost of Pencil: ");
        float pencil = scan.nextFloat();
        System.out.print("Enter the cost of Eraser: ");
        float eraser = scan.nextFloat();
        System.out.print("The toatal Bill amount Without GST is: ");
        System.out.println(pen+pencil+eraser);
        System.out.print("The toatal Bill amount With GST is: ");
        float cost = pen+pencil+eraser;
        System.out.println(cost + 18*cost/100);
        scan.close();
    }
}
