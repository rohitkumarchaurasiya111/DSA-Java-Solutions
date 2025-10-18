//Leetcode - 714
// Best Time to Buy and Sell Stock with Transaction Fee
// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.


public class Best_Time_To_Buy_And_Sell_The_Stock_With_Transaction_Fees{
    public static void main(String[] args) {
        int prices[] = {1,3,2,8,4,9};
        int fee = 2;

        //Using Tabulation in DP  - Not a good approach
        System.out.println("Using Tabulation in DP: " + maxProfitTabulation(prices,fee));

        //Using Recursion 
        System.out.println("Using Recursion: " + maxProfitRecursion(prices, fee, 0, false));    //Initially, we will begin from index 0 and isBought is false

        //Using Memoization in DP
        int dp[][] = new int[prices.length][2];     //it store the maxProfit in two cases, if bought is true or false
        //Initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1;      //if not bought     (isBought = false)
            dp[i][1] = -1;      // if bought        (isBought = true)
        }
        System.out.println("Using Memoization: " + maxProfitMemoization(prices, fee, 0, false, dp));
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        //Using Optimized Tabulation
        System.out.println("Using Optimized Tabulation: " + maxProfitTabulationOptimized(prices, fee));

        //Using Optimized Tabulation - Space Optimized
        System.out.println("Using Tabulation - Space Optimized: " + maxProfitTabulationOptimizedSpace(prices,fee));
    }

    //Using Tabulation in DP
    //This takes O(n^2) time complexity which is more
    public static int maxProfitTabulation(int[] prices, int fee) {
        int dp[][] = new int[prices.length + 1][prices.length + 1];
        //Initialization
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;   //Initially, we have 0 profits
        }

        for (int i = 1; i < dp.length; i++) {       //Buying Price
            for (int j = 0; j < dp[0].length; j++) {        //Selling Price
                if(j > i){
                    int profitIfISellToday = prices[j-1] - prices[i-1] - fee;   //Profit if i sell today
                    dp[i][j] = Math.max(Math.max(profitIfISellToday + dp[i-1][i-1], dp[i-1][j]),dp[i][j-1]);       //Max of profit - if i sell today + profit i made before bying this, profit till today if i didnot buy this share, profit if i sold this share yesterday.
                }else{
                    dp[i][j] = dp[i-1][j];      //if cannot sell today, same as yesterdays's profit
                }
            }
        }
        return dp[prices.length][prices.length];
    }

    //Using Recursion   Time Complexity - O(2^n)
    public static int maxProfitRecursion(int prices[], int fee, int i, boolean isBought){
        if(i >= prices.length) return 0;    //Base Case

        if(!isBought){      //Is Not Bought then only we can buy
            //Buy
            int ans1 = maxProfitRecursion(prices, fee, i+1, true) - prices[i];    //if i buy a share, then from maxProfit prices of that share will decrease
            //Not Buy
            int ans2 = maxProfitRecursion(prices, fee, i+1, false);
            return Math.max(ans1, ans2);
        }else{              //If We already a share holding, we cannot buy
            //Sell
            int ans1 = prices[i] - fee + maxProfitRecursion(prices, fee, i+1, false);     // if i sell the share, then the price of share will get added to my maxProfit and fee will get deducted
            //Not Sell
            int ans2 = maxProfitRecursion(prices, fee, i+1, true);
            return Math.max(ans1, ans2);
        }
    }

    //Using Memoization in DP   Time Complexity - O(n)
    public static int maxProfitMemoization(int prices[], int fee, int i, boolean isBought, int dp[][]){
        if(i >= prices.length) return 0;    //Base Case

        int bought = isBought ? 1:0;
        if(dp[i][bought] != -1) return dp[i][bought];   //return from dp, if already calculated

        if(!isBought){      //Is Not Bought then only we can buy
            //Buy
            int ans1 = maxProfitMemoization(prices, fee, i+1, true, dp) - prices[i];    //if i buy a share, then from maxProfit prices of that share will decrease
            //Not Buy
            int ans2 = maxProfitMemoization(prices, fee, i+1, false, dp);
            return dp[i][bought] = Math.max(ans1, ans2);
        }else{              //If We already a share holding, we cannot buy
            //Sell
            int ans1 = prices[i] - fee + maxProfitMemoization(prices, fee, i+1, false, dp);     // if i sell the share, then the price of share will get added to my maxProfit and fee will get deducted
            //Not Sell
            int ans2 = maxProfitMemoization(prices, fee, i+1, true, dp);
            return dp[i][bought] = Math.max(ans1, ans2);
        }
    }

    //Using Tabulation in DP
    public static int maxProfitTabulationOptimized(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // +1 to handle base case easily

        // Base case: after last day, max profit = 0 if not holding, or 0 if holding (can't sell anymore)
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // If not holding stock, we can buy or skip
            dp[i][0] = Math.max(
                -prices[i] + dp[i + 1][1],  // buy
                dp[i + 1][0]                // skip
            );

            // If holding stock, we can sell or skip
            dp[i][1] = Math.max(
                prices[i] - fee + dp[i + 1][0], // sell
                dp[i + 1][1]                    // skip
            );
        }

        // Maximum profit starting at day 0 without holding a stock
        return dp[0][0];
    }

    //Using Tabulation in DP - Space Optimized
    public static int maxProfitTabulationOptimizedSpace(int[] prices, int fee){
        int holdingProfit = 0;
        int notHoldingProfit = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            //Not Holding - Buy or Not Buy
            int currNotHolding = Math.max(-prices[i] + holdingProfit, notHoldingProfit);

            //Holding - Sell or Not sell
            int currHolding = Math.max(prices[i] - fee + notHoldingProfit, holdingProfit);

            notHoldingProfit = currNotHolding;
            holdingProfit = currHolding;
        }
        return notHoldingProfit;
    }

}