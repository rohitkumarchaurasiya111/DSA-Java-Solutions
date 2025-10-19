//Leetcode - 198, House Robber
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police

public class House_Robber {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        rob(nums);
    }
    public static void rob(int[] nums) {
        //Using Recursion
        System.out.println("Using Recursion: " +  robRecursion(nums, nums.length - 1));

        //Using Tabulation in DP
        System.out.println("Using Tabulation: " + rodTabulation(nums));
    }

    //Using Recursion
    public static int robRecursion(int nums[], int i){       //Returns the maximum amount that can be robbed
        if(i < 0) return 0;
        //Rob
        int ans1 = nums[i] + robRecursion(nums, i-2);
        //Skip
        int ans2 = robRecursion(nums, i-1);

        return Math.max(ans1, ans2);
    }

    //Using Tabulation in DP
    public static int rodTabulation(int nums[]){
        int dp[] = new int[nums.length];
        //Initialization
        dp[0] = nums[0];
        dp[1] = (nums[0] > nums[1]) ? nums[0] : nums[1];

        for (int i = 2; i < dp.length; i++) {
            
            //Rob 
            int ans1 = nums[i] + dp[i-2];
            //Skip
            int ans2 = dp[i-1];

            dp[i] = Math.max(ans1, ans2);
        }
        return dp[nums.length - 1];
    }
}
