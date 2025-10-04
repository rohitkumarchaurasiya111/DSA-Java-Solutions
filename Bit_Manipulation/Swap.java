package Bit_Manipulation;

// Swap two numbers without using any thirdvariable
public class Swap {
    public static void main(String args[]) {
        int num1 = 4;
        int num2 = 9;

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println(num1 + " " + num2);

    }
}
