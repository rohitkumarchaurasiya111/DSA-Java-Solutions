package Array;

public class BuyandSellStock {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int max_profit = 0;
        // int SP = Integer.MIN_VALUE;
        int CP = arr[0];
        // for (int i = 1; i < arr.length; i++) {
        // SP = arr[i];
        // int profit = SP - CP;
        // if (profit < 0) {
        // CP = SP;
        // } else if (profit > 0) {
        // if (profit > max_profit) {
        // max_profit = profit;
        // }
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            if (CP < arr[i]) {
                int profit = arr[i] - CP;
                max_profit = Math.max(max_profit, profit);
            } else {
                CP = arr[i];
            }
        }
        System.out.println("Max Profit is: " + max_profit);
    }
}
