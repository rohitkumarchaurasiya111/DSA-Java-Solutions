package Recursion;

public class PrintXpowerN {
    public static void main(String args[]) {
        int x = 10;
        int n = 5;
        System.out.println(power(x, n));
    }

    public static int power(int num, int exp) {
        if (exp == 0) {
            return 1;
        }
        return num * power(num, exp - 1);
    }
}
