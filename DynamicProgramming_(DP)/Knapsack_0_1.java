
// 0/1 Knapsack - Problem
// Either we can include an item or we don't 

import java.util.Arrays;

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int capacity = 7;
        int n = val.length;

        //Using Recusrion Only - No DP
        System.out.println(recursionSolution(val, wt, capacity, 0));

        //Using Memoization in DP
        int dp[][] = new int[val.length + 1][capacity + 1];     //Matrix of row = values + 1, column = capacity + 1; +1 in both because row = 0 & column = 0 will be our base cases
        //Initializing all the values to -1;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memoizationSolutionOfKnapsack(val, wt, capacity, n, dp));
        
        //Using Tabultaion in DP
        System.out.println(tabulationSolutionOfKnapsack(val, wt, capacity));

    }

    //Using Recursion only - No DP
    public static int recursionSolution(int val[], int wt[], int w, int i){
        if(w == 0 || i==val.length) return 0;       //Base Cases

        if(wt[i] <= w){     //Valid Case where we can include items
            //Include
            int ans1 = val[i] + recursionSolution(val, wt, w-wt[i], i+1);
            //Exclude
            int ans2 = recursionSolution(val, wt, w, i+1);
            //Return the maximum value we get
            return Math.max(ans1, ans2);
        }else{
            return recursionSolution(val, wt, w, i+1);
        }
    }

    //Using Memoization in DP
    public static int memoizationSolutionOfKnapsack(int val[], int wt[], int w, int n, int dp[][]){
        if(w == 0 || n==0) return 0;       //Base Cases

        if(dp[n][w] != -1){                     //If value already present in DP
            return dp[n][w];
        }
        else if(wt[n-1] <= w){                    //When value not in DP, we need to calculate
            //Include
            int ans1 = val[n-1] + memoizationSolutionOfKnapsack(val, wt, w-wt[n-1], n-1, dp);
            //Exclude
            int ans2 = memoizationSolutionOfKnapsack(val, wt, w, n-1, dp);
            //Return the maximum value we get
            return dp[n][w] = Math.max(ans1, ans2);
        }else{
            return dp[n][w] = memoizationSolutionOfKnapsack(val, wt, w, n-1, dp);
        }
    }

    //Using Tabulation in DP
    public static int tabulationSolutionOfKnapsack(int val[], int wt[], int w){
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if(i==0 || j == 0)  dp[i][j] = 0;   //Initialization 
                else if(wt[i-1] <= j){    //Valid Condition so that we can add the item (wt item <= current capacity)
                    //Include
                    int ans1 = val[i-1] + dp[i-1][j-wt[i-1]];
                    //Exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{                  //If we cannot contain current item weight in our bag
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

}
