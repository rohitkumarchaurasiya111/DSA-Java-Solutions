package Bit_Manipulation;

public class Fast_Exponentiation {
    public static void main(String args[]) {
        int num = 5;
        int exponent = 3;
        int ans = 1;
        int a = num;
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            exponent = exponent >> 1;
        }
        System.out.println(ans);
    }
    
}
