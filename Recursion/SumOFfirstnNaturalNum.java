package Recursion;

public class SumOFfirstnNaturalNum {
    public static void main(String args[]) {
        int n = 5;
        System.out.println(print_n(n));
    }

    public static int print_n(int num) {
        
        if (num <= 0) {
            return 0;
        }
        int sum = num + print_n(num - 1);
        return sum;
    }
}
