public class Minimum_Deletion_And_Insertion {
    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";
        System.out.println("Min Moves: " + minOperations(str1,str2));
    }

    public static int minOperations(String s1, String s2) {
        //First we will find the LCS between these two strings 
        //Using Tabulation in DP
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                //Initialzation
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)){  //If character matches
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{                                      //If characters doesnot match
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                
            }
        }
        int lcsValue = dp[s1.length()][s2.length()];
        
        //Calculation minimum deletions required
        int deletionsRequired = s1.length() - lcsValue;

        //Calculating minimum insertions required
        int insertionRequired = s2.length() - lcsValue;

        return deletionsRequired + insertionRequired;
    }
}
