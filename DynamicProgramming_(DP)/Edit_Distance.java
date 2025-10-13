//Leetcode - 72: Edit Distance
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
// Insert a character
// Delete a character
// Replace a character

public class Edit_Distance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        minDistance(word1, word2);
    }
    public static void minDistance(String word1, String word2) {
        //Recursion
        System.out.println("Using Recursion Only: " + minMovesRecursion(word1, word2, word1.length()-1, word2.length()-1));

        //Memoization in DP
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization in DP: " + minMovesMemoization(word1, word2, word1.length()-1, word2.length()-1, dp));
        
        //Tabulation in DP
        System.out.println("Tabulation in DP: " + minMovesTabulation(word1, word2));
    }

    //Using Recursion only
    public static int minMovesRecursion(String word1, String word2, int i, int j){
        //Base Case -> if one word has 0 length then to make both same, we have to delete all from the second one or insert same in the first one.
        if(i < 0) return j+1; 
        if(j < 0) return i+1; 

        if(word1.charAt(i) == word2.charAt(j)){     //If characters matches
            return minMovesRecursion(word1, word2, i-1, j-1);
        }else{          //If characterd doesn't matches
            //Delete
            int ans1 = 1 + minMovesRecursion(word1, word2, i-1, j);
            //Insert
            int ans2 = 1 + minMovesRecursion(word1, word2, i, j-1);
            //Replace
            int ans3 = 1 + minMovesRecursion(word1, word2, i-1, j-1);
            return Math.min(Math.min(ans1, ans2),ans3);
        }
    }

    //Using Memoization in DP
    public static int minMovesMemoization(String word1, String word2, int i, int j, int dp[][]){
        //Base Case -> if one word has 0 length then to make both same, we have to delete all from the second one or insert same in the first one.
        if(i < 0) return j+1; 
        if(j < 0) return i+1; 

        if(dp[i][j] != -1) return dp[i][j];         //If value is already calculated, return that
        if(word1.charAt(i) == word2.charAt(j)){     //If characters matches
            return dp[i][j] = minMovesMemoization(word1, word2, i-1, j-1, dp);
        }else{          //If characterd doesn't matches
            //Delete
            int ans1 = 1 + minMovesMemoization(word1, word2, i-1, j, dp);
            //Insert
            int ans2 = 1 + minMovesMemoization(word1, word2, i, j-1, dp);
            //Replace
            int ans3 = 1 + minMovesMemoization(word1, word2, i-1, j-1, dp);
            return dp[i][j] = Math.min(Math.min(ans1, ans2),ans3);
        }
    }

    //Tabulation in DP
    public static int minMovesTabulation(String word1, String word2){
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                //Initialization
                
                if(i == 0) dp[i][j] = j;    //If we have 0 characters then we have to insert characters equal to making word length
                else if(j == 0) dp[i][j] = i; //If words to make have 0 characters then we need to delete characters equal to our length
                else if(word1.charAt(i-1) == word2.charAt(j-1)){    //If characters matches
                    dp[i][j] = dp[i-1][j-1];
                }else{      //If characters doesnot matches
                    //Insert
                    int ans1 = 1 + dp[i][j-1];
                    //Delete
                    int ans2 = 1 + dp[i-1][j];
                    //Replace
                    int ans3 = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(Math.min(ans1, ans2),ans3);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
