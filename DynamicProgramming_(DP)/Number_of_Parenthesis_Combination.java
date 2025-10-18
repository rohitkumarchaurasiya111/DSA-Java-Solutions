//Number of Parenthesis Combinations Possible
//Given :- n -- no. of opening brakcet ( and closing brakcets ) to use
// Output :- no. of combination possible using that
// This follow the catalans' Number Property
// C(n) = C(0) * C(n-1) + C(1) * C(n-2) + ......... + C(n-1)*C(0)
public class Number_of_Parenthesis_Combination {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Using Tabulation: " + getCatalanNumber(n));
    }

    // Using Tabulation in DP
    public static int getCatalanNumber(int n) {
        int dp[] = new int[n + 1];
        // Initialzation
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) { // Calculating for each numbers upto target
            int ans = 0;
            for (int j = 0; j < i; j++) { // for all the combinations upto i
                ans += dp[j] * dp[i - 1 - j];
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
