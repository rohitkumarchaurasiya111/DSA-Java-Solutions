
//Climbing Stairs
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

import java.util.Arrays;

public class Climbing_Stairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsRecursion(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairsMemoization(n, dp));
        System.out.println(climbStairsRecursion(n));
    }

    //Using Recursion Only
    public static int climbStairsRecursion(int n) {         //Time Complexity - O(2^n)
        if(n < 0) return 0;
        if(n == 0) return 1;
        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }

    //Using Memoization in DP
    public static int climbStairsMemoization(int n, int dp[]){      //Time Complexity - O(n)
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];   //Value already stored in Table
        return dp[n] = climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }

    //Using Tabulation in DP
    public static int climbStairsTabulation(int n){       //Time Complexity - O(n)
        if(n < 0) return 0;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
