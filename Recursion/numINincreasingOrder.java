package Recursion;

public class numINincreasingOrder {
    public static void main(String args[]) {
        int num = 10;
        increas_order(num);
    }

    public static void increas_order(int num) {
        if (num == 0) {
            return;
        }
        increas_order(num-1);
        System.out.print(num + " ");

    }
}
