//Here, we have to find the longest increasing SubSequence
//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//In Longest Increasing Subsequence, the final answer we get will be in ascending sorte order
//So, Why not to make a copy array with all the values same as given but this array will be in ascending order sorted with only unique elements
//Now, if we try to find the longest Subsequence between these both array, the final answer will be longest increasing subsequence as one array is in ascending order

//Steps:
//1. Make a copy array sorted in ascending order
//2. Perform LCS (longest common subsequence)

import java.util.Arrays;
import java.util.HashSet;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int nums[] = {50,3,10,7,40,80};
        System.out.println(lengthOfLIS(nums));
    }

    //Using Tabulation in DP
    public static int lengthOfLIS(int[] nums) {
        //Making a copy of Array with only unique elements present
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);   //stores only the unique elements
        }
        int i = 0;
        int copyArray[] = new int[set.size()];
        for (Integer value : set) {
            copyArray[i++] = value;
        }
        Arrays.sort(copyArray);   //Sorting the copy array

        //Performing LCS on both arrays
        //Tabulation in DP
        int dp[][] = new int[nums.length + 1][copyArray.length + 1];
        for (int j = 0; j < dp.length; j++) {
            for (int k = 0; k < dp[0].length; k++) {
                if(j==0 || k ==0) dp[j][k] = 0; //Initialization
                else if(nums[j-1] == copyArray[k-1]){ //Value Matches
                    dp[j][k] = 1 + dp[j-1][k-1];
                }else{  //Doesnot match
                    dp[j][k] = Math.max(dp[j-1][k], dp[j][k-1]);
                }
            }
        }
        return dp[nums.length][copyArray.length];

    }

    
}
