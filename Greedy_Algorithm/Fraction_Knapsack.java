package Greedy_Algorithm;
//Given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

import java.util.Arrays;
import java.util.Comparator;

// value = [60, 100, 120]
// ans = 240
// weight = [10, 20, 30]
// W = 50

public class Fraction_Knapsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int capacity = 50;

        int ratio[] = new int[value.length];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = value[i] / weight[i];
        }
        // Here, we need to have ratio[] in sorted order
        int info[][] = new int[ratio.length][4];
        for (int i = 0; i < info.length; i++) {
            info[i][0] = i;
            info[i][1] = value[i];
            info[i][2] = weight[i];
            info[i][3] = ratio[i];
        }
        Arrays.sort(info, Comparator.comparingDouble(o -> o[3]));

        int max_value = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            if (info[i][2] <= capacity) {
                capacity = capacity - info[i][2];
                max_value += info[i][3] * info[i][2];
            } else {
                max_value += info[i][3] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println("Maximum Value we can keep is: " + max_value);
    }
}
