package Bit_Manipulation;
public class Check_OddOrEven{
    public static void main (String args[]){
        int num = 6;
        int bitmask = 1;
        if ((num & 1) == bitmask) {
            System.out.println("The number is Odd!");
        }else {
            System.out.println("The number is Even!");
        }
    }
}