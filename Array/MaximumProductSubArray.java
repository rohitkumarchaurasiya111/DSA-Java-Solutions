package Array;

//Leetcode 152. Maximum Product Subarray
//Given an integer array nums, find a subarray that has the largest product, and return the product.

class MaximumProductSubArray {

    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }

    // Using Logic of Kadane's Algorithm and Modifing it for this question as it
    // contains Negative Numbers.
    public static int maxProduct(int[] nums) {
        int minProd = nums[0]; // This will store the minimum product upto now
        int maxProd = nums[0]; // This will store the maximum product upto now
        int globalMax = nums[0]; // Maximum value that we got

        for (int i = 1; i < nums.length; i++) {
            // If current number is negative, swap min and max
            // because a negative number turns a max into a min and vice versa
            if (nums[i] < 0) {
                int temp = minProd;
                minProd = maxProd;
                maxProd = temp;
            }
            maxProd = Math.max(nums[i], maxProd * nums[i]); // Looking if max is after product or I am maximum
            minProd = Math.min(nums[i], minProd * nums[i]); // Looking if min is after product or I am minimum
            globalMax = Math.max(globalMax, maxProd);
        }
        return globalMax;
    }

}
