//Leetcode 45 - Jump Game II

import java.util.Arrays;

public class Minimum_Array_Jumps {
    public static void main(String[] args) {
        int nums[] = {2,3,0,1,4};
        jump(nums);
    }
    public static void jump(int[] nums) {
        //Using Recursion
        System.out.println("Using Recursion: " + minJumpRecursion(nums, 0));

        //Using Memoization in dp
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println("Using Memoization in DP: " + minJumpMemoization(nums, 0, dp));

        //Using Tabulation in dp
        System.out.println("Using Tabulation in DP: " + minJumpTabulation(nums));
    }

    //Using Recursion
    static int minJumpRecursion(int nums[], int i){
        if(i >= nums.length - 1) return 0;  //We have reached our destination
        if(nums[i] == 0) return nums.length;
        int minJumpsNeeded = nums.length; 
        for (int j = 1; j <= nums[i]; j++) {        //taking all the jumps possible
            int ans =  1 + minJumpRecursion(nums, i+j);
            minJumpsNeeded = Math.min(ans, minJumpsNeeded);
        }
        return minJumpsNeeded;
    }

    //Using Memoization in DP
    static int minJumpMemoization(int nums[], int i, int dp[]){
        if(i >= nums.length - 1) return 0;  //We have reached our destination
        if(nums[i] == 0) return nums.length;    //if value = 0, it means jump is not possible. So, Returning the maximum value possible
        if(dp[i] != -1) return dp[i];   //if already present, no need to calculate again

        int minJumpsNeeded =  nums.length;      //jumps cannot be more than this
        for (int j = 1; j <= nums[i]; j++) {        //taking all the jumps possible
            int ans =  1 + minJumpMemoization(nums, i+j, dp);
            minJumpsNeeded = Math.min(ans, minJumpsNeeded);
        }
        return dp[i] = minJumpsNeeded;
    }

    //Using Tabulation in DP
    static int minJumpTabulation(int nums[]){
        int dp[] = new int[nums.length];
        //Initialization
        Arrays.fill(dp, nums.length);       //Assigning max value in all places of dp
        dp[nums.length - 1] = 0;    //this is our destination

        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] <= 0){       //it means we cannot jump. So, assigning the maximum value there
                dp[i] = nums.length;
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if(i + j >= nums.length - 1){
                    dp[i] = 1;
                }else{
                    dp[i] = Math.min(dp[i], 1 + dp[i+j]);
                }
            }
        }

        return dp[0];
    }
    
}
