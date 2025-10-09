public class Unbounded_knapsack {
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int capacity = 7;
        int n = val.length;
        tabulationSolution(val, wt, capacity);
    }

// T.C. = O(size of dp matrix);
    public static void tabulationSolution(int val[], int wt[], int capacity){
        int dp[][] = new int[val.length + 1][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0 || j==0) dp[i][j] = 0;  //Initalization
                else if(wt[i-1] <= j){          //Valid Condition
                    //Include
                    int ans1 = val[i-1] + dp[i][j-wt[i-1]];     //After including i, here we will again include it
                    //Exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{                          //InValid COndition
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[val.length][capacity]);
    }
}
