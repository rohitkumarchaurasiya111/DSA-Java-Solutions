package Greedy_Algorithm;

//Best Time to Buy and Sell Stock

// Given an array prices of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible for buying and selling the stocks on different days using transactions where at most one transaction is allowed.
// Note: Stock must be bought before being sold.

// Sample Input 1: prices[] = {7, 6, 4, 3, 1}
// Sample Output 1:0

public class Ass_Q4 {
    public static void main(String[] args) {
        int prices[] = { 7, 6, 4, 3, 1 };
        int max_profit = 0;
        int cp = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < cp) {
                cp = prices[i];
            } else {
                max_profit = Math.max(max_profit, prices[i] - cp);
            }
        }
        System.out.println(max_profit);
    }
}
