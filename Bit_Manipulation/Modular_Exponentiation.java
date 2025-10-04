package Bit_Manipulation;

public class Modular_Exponentiation {
    public static void main(String args[]) {
        int num = 2;
        int exponent = 5;
        int modulo = 13;
        modular_exponent(num, exponent, modulo);
    }

    public static void modular_exponent(int a, int exp, int x) {
        int ans = 1;
        while (exp > 0) {
            if (a % x == 0) {
                ans = 0;
                break;
            }
            if ((exp & 1) != 0) {
                ans = (ans * a) % x;
            }
            a = (a * a) % x;
            exp = exp >> 1;
        }
        System.out.println(ans);
    }
}
