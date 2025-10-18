//Print all combinations of balanced parenthesis
//Write a function to generate all possible n pairs of balanced parenthesis
//Example: n=2, output - ()() , (())
//Leetcode - 22, Generate Parenthesis

import java.util.*;

public class Combination_of_Balanced_Parenthesis {
    public static void main(String[] args) {
        int n = 3;
        // Using Recursion
        System.out.println(generateParenthesisRecursion(n));

        // Using Common Recursive Approach to Solve
        List<String> combinations = new ArrayList<String>();
        generateParenthesisCommonRecursion(n, "", 0, 0, combinations);
        System.out.println(combinations);

        // Using Tabulation in DP
        System.out.println(generateParenthesisTabulation(n));
    }

    // Using Recursion
    public static List<String> generateParenthesisRecursion(int n) {
        // Base Cases
        if (n == 0)
            return Arrays.asList("");
        if (n == 1)
            return Arrays.asList("()");
        List<String> combinations = new ArrayList<String>(); // to store differnet combinations for given n

        for (int i = 0; i < n; i++) { // to see different combinations
            List<String> comb1 = generateParenthesisRecursion(i);
            List<String> comb2 = generateParenthesisRecursion(n - 1 - i);
            for (int j = 0; j < comb1.size(); j++) { // Find all the different combinations
                for (int k = 0; k < comb2.size(); k++) {
                    String ans = "(" + comb1.get(j) + ")" + comb2.get(k); // our structure
                    combinations.add(ans);
                }
            }
        }
        return combinations;
    }

    // Most Common Recursive Approach to solve
    public static void generateParenthesisCommonRecursion(int n, String ans, int startBracketCount, int endBracketCount,
            List<String> combinations) {
        if (ans.length() == n * 2) { // if answer has reached the target, add that to result
            combinations.add(ans);
            return;
        }

        if (startBracketCount < n) { // if still we can add ( then add
            generateParenthesisCommonRecursion(n, ans + '(', startBracketCount + 1, endBracketCount, combinations);
        }
        if (endBracketCount < startBracketCount) { // add ) only if it is valid, i.e. only if ( is present
            generateParenthesisCommonRecursion(n, ans + ')', startBracketCount, endBracketCount + 1, combinations);
        }
    }

    // Using Tabulation in DP
    public static List<String> generateParenthesisTabulation(int n) {
        List<String> dp[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        if (n > 0)
            dp[1].add("()");

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                List<String> comb1 = dp[j];
                List<String> comb2 = dp[i - 1 - j];
                for (int k1 = 0; k1 < comb1.size(); k1++) {
                    for (int k2 = 0; k2 < comb2.size(); k2++) {
                        String ans = '(' + comb1.get(k1) + ')' + comb2.get(k2);
                        dp[i].add(ans);
                    }
                }
            }
        }
        return dp[n];
    }
}
