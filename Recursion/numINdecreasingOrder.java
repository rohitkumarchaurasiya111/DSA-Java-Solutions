package Recursion;

public class numINdecreasingOrder {
    public static void main(String args[]) {
        int num = 10;
        numINdecreasingOrder obj = new numINdecreasingOrder();
        obj.dercreasing_order(num);
    }

    public void dercreasing_order(int num) {
        if (num < 0) {
            return;
        }
        System.out.print(num + " ");
        dercreasing_order(num - 1);
    }
}
