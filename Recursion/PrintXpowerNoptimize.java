package Recursion;

public class PrintXpowerNoptimize {
    public static void main(String args[]) {
        int X = 10;
        int N = 5;
        System.out.println(power(X, N));
    }

    public static int power(int num, int exp) {
        if (exp == 0) {
            return 1;
        }

        int temp = power(num, exp / 2);
        int halfpowersq = temp * temp;
        if (exp % 2 != 0) {
            halfpowersq = halfpowersq * num;
        }
        return halfpowersq;

    }
}
