//Combination Sum IV
//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//Here, We need to return all the permutation, not the unique one only...
//1,1,2     1,2,1      2,1,1 -> counted 3 not 1.

import java.util.Arrays;
public class CombinationSum4{
    public static void main(String[] args) {
        int nums[] = {1,2,3}, target = 4;
        combinationSum4(nums,target);
    }
    public static void combinationSum4(int[] nums, int target) {
        System.out.println("Recursion with Loop (Permutation): " + combinationSumRecursion(nums,target));
        System.out.println("Recursion only (Combination): " + combinationSumRecursion2(nums,target,0));
        //Memoization in Dp
        int dp[] = new int[target + 1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        System.out.println("Memoization: " + combinationSumMemoization(nums,target,dp));
        System.out.println("Tabulation: " + combinationSumTabulation(nums,target));
    }


    //Using Simple Recursion as well as LOOP -> Gives Permutation (All the combinations)  Leetcode - 337
    public static int combinationSumRecursion(int[] nums, int target){
        if(target == 0) return 1;   //Base case
        int ans = 0;
        for (int i = 0; i < nums.length; i++) { //Explores all the permuations possible
            if(target >= nums[i]){
                ans += combinationSumRecursion(nums, target-nums[i]);
            }
        }
        return ans;
    }


    //Using Only Recursion -> Gives Combination (Unique Combinations Only)  Leetcode - 39
    public static int combinationSumRecursion2(int[] nums, int target, int i){
        if(target == 0) return 1;   //Base case
        if(i >= nums.length || target<0) return 0;
        int includeWays = 0;
        //Include
        if(target >= nums[i])
            includeWays = combinationSumRecursion2(nums, target-nums[i], i);
        //Exclude
        int excludeWays = combinationSumRecursion2(nums, target, i+1);
        return includeWays + excludeWays;
    }


    //Using Memoization in DP
    public static int combinationSumMemoization(int[] nums, int target, int dp[]){
        if(dp[target] != -1) return dp[target]; //If already calculated, No need to calculate again
        int ans = 0;
        for (int i = 0; i < nums.length; i++) { //Explores all the permuations possible
            if(target >= nums[i]){
                ans += combinationSumMemoization(nums, target-nums[i],dp);
            }
        }
        return dp[target] = ans;
    }


    //Using Tabulation in DP
    public static int combinationSumTabulation(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {     // target loop
            for (int j = 0; j < nums.length; j++) {     // numbers loop
                if(i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
