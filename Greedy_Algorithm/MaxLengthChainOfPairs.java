package Greedy_Algorithm;
// Max Length Chain of Pairs

import java.util.Arrays;
import java.util.Comparator;

// You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can come after pair (a, b) if b < c. Find the longest chain which can be formed from a given set of pairs.
// pairs =
// (5, 24)
// (39,60)
// (5, 28)
// (27, 40)
// (50,90)
// ans = 3

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // Sort on the basis of b in (a,b) as b is the end time and if b is small then
        // we can take more pairs
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int max_length = 1;
        int last_considered_end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] >= last_considered_end) {
                max_length++;
                last_considered_end = pairs[i][1];
            }
        }
        System.out.println("Max Length of Chain: " + max_length);
    }
}
