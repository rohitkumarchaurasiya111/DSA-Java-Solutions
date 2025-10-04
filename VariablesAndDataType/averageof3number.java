package VariablesAndDataType;
//In a program,input 3 numbers:A,BandC.You have to output the average of these 3 numbers.
import java.util.*;
public class averageof3number {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a,b,c: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int avg = (a + b + c) / 3;
        System.out.print("Average value is: ");
        System.out.println(avg);
        scan.close();
    }
}
