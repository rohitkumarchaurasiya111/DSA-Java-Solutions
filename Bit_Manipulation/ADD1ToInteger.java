package Bit_Manipulation;

public class ADD1ToInteger {
    public static void main(String args[]){
        int num  = 10;
        System.out.println(add1(num));
    }
    public static int add1(int num){
        num = -(~num);
        return num;
    }
}
