public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        System.out.println(fibonacciNumberMemoization(n, dp));
        System.out.println(fibonacciNumberTabulation(n, dp));
    }

    // Without Using DP
    public static int fibonacciNumber(int n) { // Time Complexity - O(2^n)
        if (n == 0 || n == 1)
            return n;

        return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
    }

    // Using Memoization in DP
    public static int fibonacciNumberMemoization(int n, int dp[]) { // Time Complexity - O(n)
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != 0)
            return dp[n]; // Fibonacci of n already calculated
        dp[n] = fibonacciNumberMemoization(n - 1,dp) + fibonacciNumberMemoization(n - 2,dp);
        return dp[n];
    }

    // Using Tabulation in DP
    public static int fibonacciNumberTabulation(int n, int dp[]) { // Time Complexity - O(n)
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}