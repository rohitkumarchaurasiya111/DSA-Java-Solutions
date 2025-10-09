
//This is similar to unbounded Knapsack problem as we can choose any number of coins to reach our target
public class Coin_Change {
    public static void main(String[] args) {
        int coins[] = {1,3,5};
        int targetAmount = 11;
        System.out.println(coinChange1(coins,targetAmount));
        System.out.println(coinChange2(coins,targetAmount));
    }

    //Coin Change - 1 -> Leetcode - 332
    //Minimum number of coins required to get the target amount
    public static int coinChange1(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0) dp[i][j] = 0;          //if sum = 0, then coins requried = 0
                else if(i==0) dp[i][j] = Integer.MAX_VALUE;     //if we don't have coins then no. of coins required would be infinity
                else if(coins[i-1] <= j){      //Valid
                    //Include
                    int ans1 = Integer.MAX_VALUE;
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE)
                        ans1 = 1 + dp[i][j-coins[i-1]];
                    //Exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.min(ans1, ans2);
                }else{                              //Invalid
                    //Exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount] != Integer.MAX_VALUE)   return dp[coins.length][amount];
        return -1;
    }

    //Coin change 2 -> leetcode - 332
    //Possible no. of total ways to get the amount
    public static int coinChange2(int[] coins, int amount){
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0) dp[i][j] = 1;          //if sum = 0, then no. of ways to get it is 1, no need to give any coins
                else if(i==0) dp[i][j] = 0;     //if we don't have coins then there is no No. of ways to get the sum. So 0 as 0 means no possible
                else if(coins[i-1] <= j){      //Valid
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];    //Total no. of ways to get this sum = no. of way I can get (current amount - me) (as if i get added the way remains same) + no. of ways that without me is possible
                }else{                         //Invalid
                    //Exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount] != 0)   return dp[coins.length][amount];
        return 0;
    }
}
