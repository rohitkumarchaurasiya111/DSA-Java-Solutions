// Tibonacci Numbers
//The tibonacci seies is a generalization of the Fibonacci sequence where each items is the sum of the three preceding terms
// a(n) = a(n-1) + a(n-2) + a(n-3)
//where, a(0) = 0 , a(1) = 1, a(2) = 1


// Leetcode - 1137


public class Tibonacci_Numbers {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Using Tabulation, Tibonacci - : " + tribonacci(n));
    }


    //Using Tabulation in DP
    public static int tribonacci(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        if(n==3) return 1;
        int dp[] = new int[n+1];
        //Initialization
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;


        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];        //Calculating for each numbers upto our target
        }
        return dp[n];
    }
}
