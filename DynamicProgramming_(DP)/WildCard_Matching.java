// Leetcode - 44: WildCard Matching
// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

public class WildCard_Matching {
    public static void main(String[] args) {
        String text = "aab";
        String pattern = "c*a*b";
        isMatch(text, pattern);
    }

    public static void isMatch(String s, String p) {
        System.out.println("Tabulation in DP: " + isMatchPossible(s, p));
    }

    //Using Tabulation in DP
    public static boolean isMatchPossible(String s, String p){
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];   //This will store either at a specific point, pattern matches the string or not

        //Initialization
        dp[0][0] = true;            //If pattern is empty and string is empty, then it's a match
        
        for (int j = 1; j < dp[0].length; j++) {    //If string is empty and pattern is *, then it's a match
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }

        //Different Cases
        for (int i = 1; i < dp.length; i++) {   //String
            for (int j = 1; j < dp[0].length; j++) {    //Pattern
                if(p.charAt(j-1) == '*'){   //if pattern is *
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];    //Considering * as string (but we don't exclude * as * can be used further , if not useful then in future, it will be considered empty) and considering * as the empty 
                }else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){  //if pattern is ? or If both characters are same
                    dp[i][j] = dp[i-1][j-1];
                }else{                          //if both characters are different
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
