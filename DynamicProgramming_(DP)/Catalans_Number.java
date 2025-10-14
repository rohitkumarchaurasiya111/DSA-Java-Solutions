//Catalan numbers count the number of distinct ways to arrange or build something recursively structured — where the subparts have the same pattern as the whole.
// Cn = C0 * Cn-1 + C1 * Cn-2 + ..... + Cn-1 * C0

public class Catalans_Number {
    public static void main(String[] args) {
        int n = 3;
        //Using Recursion
        System.out.println("Using Recursion: " + findCatalanRecursion(n));

        //Using Memoization in DP
        int dp[] = new int[n+1];
        System.out.println("Using Memoization: " + findCatalanMemoization(n,dp));

        //Using Tabulation in DP
        System.out.println("Using Tabulation: " + findCatalanTabulation(n));

        //Using Direct Formula
        System.out.println("Using Formula Directly: " + findCatalanDirectFormula(n));
    }

    //Using Recursion
    public static int findCatalanRecursion(int n){
        if(n==0 || n==1) return 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += findCatalanRecursion(i) * findCatalanRecursion(n-i-1);
        }
        return ans;
    }

    //Using Memoization in DP
    public static int findCatalanMemoization(int n, int dp[]){
        if(n==0 || n==1) return 1;  //Base Cases
        if(dp[n] != 0) return dp[n];    //If value already calculated return it

        //if not calculated yet
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += findCatalanMemoization(i, dp) * findCatalanMemoization(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    //Using Tabulation in DP
    public static int findCatalanTabulation(int n){
        int dp[] = new int[n+1];
        //Initialziation
        dp[0] = 1;
        dp[1] = 1;

        //Calcualating Catalan's Number
        for (int i = 2; i <= n; i++) {  //n
            int ans = 0;
            for (int j = 0; j < i; j++) {   //0 -> n-1
                ans += dp[j] * dp[i-j-1];   // 0 -> n-1 * n-1 -> 0
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    //Using Direct Formuls
    public static int findCatalanDirectFormula(int n){
        return findFactorial(2*n) / (findFactorial(n+1) * findFactorial(n));
    }

    static int findFactorial(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = i * dp[i-1];
        }
        return dp[n];
    }
}
