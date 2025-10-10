// Rod Cutting Problem
// Given a rod of length n inches and an array price[] where price[i] represents the price of a rod piece of length i + 1,
// determine the maximum value obtainable by cutting up the rod and selling the pieces.
//This problem is similar to Unbounded Knapsack becasue here, we can either choose or not choose and item and we can choose an item any no. of times but not in fraction

public class Rod_Cutting {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        System.out.println("Maximum value obtainable: " + rodCutting(length, price, rodLength));
        System.out.println("Using 1D Dp Array: " + rodCutting2(length, price, rodLength));
    }

    public static int rodCutting(int[] length, int[] price, int rodLength){
        int dp[][] = new int[length.length + 1][rodLength + 1];
        //Here, when i=0 || j=0 dp[i][j] = 0; -> Initialization
        // i -> different lengths having different prices given
        // j -> current rodLengths allowed
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(length[i-1] <= j){       //Valid
                    //Maximum of the valid and invalid cases
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]],dp[i-1][j]);
                }else{                      //Invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("2D array DP:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }
        return dp[length.length][rodLength];
    }

    //Taking only 1D - Array in DP
    public static int rodCutting2(int[] length, int[] price, int rodLength){
        int dp[] = new int[rodLength + 1];
        dp[0] = 0; //Initialization

        // j -> different lengths having different prices given
        // i -> current rodLengths allowed
        for (int i = 1; i < dp.length; i++) {       //Capacity loop
            for (int j = 0; j < length.length; j++) {       //Items loop
                if(length[j] <= i){
                    dp[i] = Math.max(dp[i], price[j] + dp[i-length[j]]);
                }
            }
        }
        System.out.println("1D Array DP: ");
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "   ");
        }
        System.out.println();
        return dp[rodLength];
    }
}
