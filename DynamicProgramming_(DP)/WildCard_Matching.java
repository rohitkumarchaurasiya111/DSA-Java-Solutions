// Leetcode - 44: WildCard Matching
// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

public class WildCard_Matching{
    public static void main(String[] args) {
        String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
        String p = "*aabb***aa**a******aa*";
        isMatch(s,p);
    }


    public static void isMatch(String s, String p) {
        //Using Recursion
        System.out.println("Using Recursion: " + isMatchRecursion(s,p,s.length()-1,p.length() - 1));


        //Using Memoization in DP
        int dp[][] = new int[s.length()][p.length()];   //Using Integer dp, as here we can keep track that the value is updated one or not, if boolean dp is used, we need to make another dp visited to see if it is the udpated value or not
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization: " + isMatchMemoization(s,p,s.length()-1, p.length()-1, dp));


        //using Tabulation in DP
        System.out.println("Using Tabulation in DP: " + isMatchTabulation(s,p));
    }


    //Using Recursion
    public static boolean isMatchRecursion(String s, String p, int i, int j){   //i -> String, j -> Pattern
        if(i < 0 && j < 0) return true; //if both characters finishes it's true
        if(i < 0 && j >= 0){         //if character is finished and pattern only remain
            //we will check if pattern remain is * only then true else false
            for (int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;    //if remaining pattern contains something except the * then return false
            }
            return true;  //if remaining pattern is * only then return true;
        }
        if(i >= 0 && j < 0) return false; //if string remains and pattern finishes then return false


        //if pattern is star
        if(p.charAt(j) == '*'){
            return isMatchRecursion(s, p, i-1, j) || isMatchRecursion(s,p, i, j-1);
        }
        //if pattern is ? or it's a match
        if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
            return isMatchRecursion(s,p,i-1, j-1);
        }
        //if doesnot match
        return false;
    }


    //Using Memoization in DP
    public static boolean isMatchMemoization(String s, String p, int i, int j, int dp[][]){ //i -> String, j -> Pattern
        //base cases
        if(i<0 && j<0) return true; //if string and pattern both finishes
        if(i<0 && j>=0){    //If string finishes but pattern remains. In this case, to be true the pattern remain should be * only
            for (int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;    //if pattern remain contians any other character than * then it is false
            }
            return true;    //if pattern remain contains * only then it is true
        }
        if(i>=0 && j<0) return false; //if string is present but pattern finishes


        if(dp[i][j] != -1){ //if already value is present then return that
            return (dp[i][j] == 1)? true: false;
        }


        //Different scenarios
        if(p.charAt(j) == '*'){ //if character of pattern is *
            dp[i][j] = (isMatchMemoization(s,p,i-1,j,dp) || isMatchMemoization(s,p, i, j-1,dp))?1:0;
            return (dp[i][j] == 1)? true: false;
        }else if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){ //is both characters matches or if pattern is ?
            dp[i][j] = (isMatchMemoization(s, p, i-1, j-1, dp))?1:0;
            return (dp[i][j] == 1)? true: false;
        }else{  //if characters doesnot match
            dp[i][j] = 0;
            return (dp[i][j] == 1)? true: false;
        }
       
    }


    //Using Tabulation in DP
    public static boolean isMatchTabulation(String s, String p){
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];


        //Initialization
        dp[0][0] = true; //pattern is empty and string is empty -> so, its a match
        for (int j = 1; j < dp[0].length; j++) {    //iterating over the pattern
            if(p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];   //string is empty and pattern is * -> it's a match.
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //if pattern is *
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];   //It can match with a string or it can be a blank space
                }else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){ //if it's a ? or it character matches
                    dp[i][j] = dp[i-1][j-1];
                }else{      //if characters doesnot match
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
