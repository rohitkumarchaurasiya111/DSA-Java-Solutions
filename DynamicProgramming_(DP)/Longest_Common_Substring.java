//Longest Common SubString
//This problem is different form Longest Common Subsequence as we need to find the longest substring. So, if there comes gap the values counting comes to 0 again
//Easiest approach is to do using Tabulation method and keep a variable to track the maximum length of SubString


public class Longest_Common_Substring {
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
       
        //Using Recursion -> Using one extra variable for the track of maximum SubString.
        longestCommonSubString(str1, str2, str1.length()-1, str2.length()-1, 0);
        System.out.println("Using Recursion, maxSubStringCount Variable - : " + maxSubStringCount);


        //Using Memoization in DP ->
        int dp[][] = new int[str1.length()][str2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        longestCommonSubStringMemoization(str1,str2,str1.length()-1,str2.length()-1,dp);
        System.out.println("Mamoization in DP: Max count Variable: " + maxSubStringCount2);


        //Using Tabulation in DP
        System.out.println("Using Tabulation in DP: " + longestCommonSubStringTabulation(str1,str2));
   
    }


    static int maxSubStringCount = 0;
    //Using Recursion only
    public static int longestCommonSubString(String str1, String str2, int i, int j, int matchCount){
        if(i < 0 || j < 0) return matchCount;  //Base Case
       
        //Characters Match
        if(str1.charAt(i) == str2.charAt(j)){
            matchCount++;
            maxSubStringCount = Math.max(maxSubStringCount, matchCount);
            longestCommonSubString(str1, str2, i-1, j-1, matchCount);
        }
        //Doesnot Match -> matchCount = 0;
        int ans1 = longestCommonSubString(str1, str2, i-1, j, 0);  
        int ans2 = longestCommonSubString(str1, str2, i, j-1, 0);
        return Math.max(ans1,ans2);
    }




    //Using Memoization in DP
    //This function returns highest no. of matches possible
    static int maxSubStringCount2 = 0;
    public static int longestCommonSubStringMemoization(String str1, String str2, int i, int j, int dp[][]){
        if(i < 0 || j < 0) return 0;  //Base Case
        if(dp[i][j] != -1) return dp[i][j];     //If value is already present return that
        //Characters Match
        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = 1 + longestCommonSubStringMemoization(str1, str2, i-1, j-1, dp);
            maxSubStringCount2 = Math.max(maxSubStringCount2, dp[i][j]);
        }else{
            dp[i][j] = 0;
        }
       
        //Doesnot Match
        longestCommonSubStringMemoization(str1, str2, i-1, j, dp);
        longestCommonSubStringMemoization(str1, str2, i, j-1, dp);
        return dp[i][j];
    }


    //Using Tabulation in DP
    public static int longestCommonSubStringTabulation(String str1, String str2){
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int maxCountOfSubString = 0;           //Variable to track the maximum size of SubString that we got
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 || j==0) dp[i][j] = 0; //Initialization
                else if(str1.charAt(i-1) == str2.charAt(j-1)){  //If characters are same
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxCountOfSubString = Math.max(maxCountOfSubString, dp[i][j]);
                }
            }
        }
        return maxCountOfSubString;
    }
}



