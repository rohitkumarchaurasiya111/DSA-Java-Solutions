package Recursion;

public class factorial {
    public static void main(String args[]) {
        int fact = 5;
        System.out.println(fact(fact));
    }

    public static int fact(int num) {
        if (num <= 0) {
            return 1;
        }
        return num * fact(num - 1);
    }
}
