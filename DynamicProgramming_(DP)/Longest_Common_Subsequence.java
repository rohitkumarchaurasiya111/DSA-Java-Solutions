public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        longestCommonSubsequence(str1, str2);
    }
    public static void longestCommonSubsequence(String text1, String text2) {
        System.out.println("Recursion: " + lcsRecursion(text1, text2, text1.length()-1, text2.length()-1));
        int dp[][] = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Memoization in DP: " + lcsMemoization(text1, text2, text1.length()-1, text2.length()-1, dp));
        System.out.println("Tabulation in DP: " + lcsTabulation(text1, text2));
    }

    //Using Recursion 
    public static int lcsRecursion(String str1, String str2, int str1Pointer, int str2Pointer){
        //Base Case
        if(str1Pointer < 0 || str2Pointer < 0)  return 0;
        if(str1.charAt(str1Pointer) == str2.charAt(str2Pointer)){     //If both characters are same
            return 1 + lcsRecursion(str1, str2, str1Pointer-1, str2Pointer-1);
        }else{      //If both characters are different
            int ans1 = lcsRecursion(str1, str2, str1Pointer-1, str2Pointer);
            int ans2 = lcsRecursion(str1, str2, str1Pointer, str2Pointer-1);
            return Math.max(ans1, ans2);
        }
    }

    //Using Memoization in DP
    public static int lcsMemoization(String str1, String str2, int str1Pointer, int str2Pointer, int[][] dp){
        if(str1Pointer < 0 || str2Pointer < 0)  return 0;
        if(dp[str1Pointer][str2Pointer] != -1) return dp[str1Pointer][str2Pointer]; //If value is already calculated return from DP
        if(str1.charAt(str1Pointer) == str2.charAt(str2Pointer)){     //If both characters are same
            return dp[str1Pointer][str2Pointer] = 1 + lcsMemoization(str1, str2, str1Pointer-1, str2Pointer-1,dp);
        }else{      //If both characters are different
            int ans1 = lcsMemoization(str1, str2, str1Pointer-1, str2Pointer,dp);
            int ans2 = lcsMemoization(str1, str2, str1Pointer, str2Pointer-1,dp);
            return dp[str1Pointer][str2Pointer] = Math.max(ans1, ans2);
        }
    }

    //Using Tabulation in DP
    public static int lcsTabulation(String text1, String text2){
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < dp.length; i++) {       //text1 loop
            for (int j = 0; j < dp[0].length; j++) {    //text2 loop
                if(i==0 || j==0) dp[i][j] = 0;
                else if(text1.charAt(i-1) == text2.charAt(j-1)){    //If both characters are same
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{          //If both characters are different 
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
