package Recursion;

public class NthFibonacciNumber {
    public static void main(String args[]) {
        int nth = 7;
        System.out.println(N_fibonacci(nth));
    }

    public static int N_fibonacci(int num) {
        if (num == 2) {
            return 1;
        }
        if (num == 1) {
            return 0;
        }
        int sum = N_fibonacci(num - 1) + N_fibonacci(num - 2);
        return sum;

    }
}