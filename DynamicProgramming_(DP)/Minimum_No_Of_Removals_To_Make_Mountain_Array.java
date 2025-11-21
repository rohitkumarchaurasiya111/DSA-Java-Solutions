//Leetcode - 1671. Minimum Number of Removals to Make Mountain Array (Hard)

// You may recall that an array arr is a mountain array if and only if:
// arr.length >= 3
// There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.

import java.util.*;

public class Minimum_No_Of_Removals_To_Make_Mountain_Array {
    public static void main(String[] args) {
        // int nums[] = {2,1,1,5,6,2,3,1};
        // int nums[] = {1,5,6,2,1};
        int nums[] = { 100, 92, 89, 77, 74, 66, 64, 66, 64 };
        // int nums[] = {4,3,2,1,1,2,3,1};
        // int nums[] = {10, 1, 5, 1};
        minimumMountainRemovals(nums);
    }

    public static void minimumMountainRemovals(int[] nums) {
        // Optimized and Standard Approach

        // In DP, For removal cases, we will track the maximum length whenver possible
        // When solving Dynamic Programming problems that ask for "Minimum Removals" (or
        // Deletions), you should almost never count the removals directly.
        // The Golden Equation (The Inversion Principle)
        // This is the single most important rule. "Removal" is negative space; it is
        // hard to define what you don't want. "Subsequence" is positive space; it is
        // easy to define what you do want.

        // Never calculate: Min(Removals) Always calculate: Max(Length of Valid
        // Subsequence)
        // Min Removals = Total Array Length - Max Valid Subsequence Length

        // Calculate Longest Increasing Subsequence from first to last
        int lis[] = new int[nums.length];
        Arrays.fill(lis, 1); // Initally, lis is 1, as the number itself form a length of 1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // valid case, in this case only subsequence can exist
                    lis[i] = Math.max(lis[i], lis[j] + 1); // if someone can give lis x then by combining me it can be x
                                                           // + 1 as i am bigger than someone
                }
            }
        }

        // Calculating Longest Decreasing Subsequence from Last to first
        int lds[] = new int[nums.length];
        Arrays.fill(lds, 1); // Initally, lds is 1, as the number itself form a length of 1
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) { // valid case, in this case only decreasing subsequence can exist
                    lds[i] = Math.max(lds[i], lds[j] + 1); // if someone can give lds x then by combining me it can be x
                                                           // + 1 as i am smaller than someone
                }
            }
        }

        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println("LIS: " + lis[i] + " LDS: " + lds[i]);
        // }

        // Find the HighestPeak, -> HighestPeak is that one which give the highest
        // number of elements (means lowest removals) and the LIS is more than 1 as well
        // as the LDS is more than 1
        // First and last elements can never be the HighestPeak
        int maxElements = 0; // minimum Removals means Maximum Length of the Array
        for (int i = 1; i < nums.length - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) // Our Maximum Peak means it has atleast one elemnet on it's left and one on
                                          // it's right. So, It should make longest increasing subsequence of length
                                          // more than 1 and Longest decreasing subsequence of length more than 1
                maxElements = Math.max(maxElements, lis[i] + lds[i] - 1); // Subtracting 1 as HighestPeak is calculated
                                                                          // in both the LIS and LDS cases
        }

        int elementsRemoved = nums.length - maxElements;

        System.out.println("Tabulation in DP, Minimum Removals : " + elementsRemoved);

        // -----------LOOK ONLY IF YOU HAVE ENOUGH TIME--------------

        // Using DP and Recursion
        // Here, We are tracking the no. of removals which is not an effecient approach
        // insted of tracking removals we should track the Length

        int minRemovals = nums.length; // Maximum no. of removals possible = length of the Array

        // Using Two DP Array to Optimize
        int dp1[][] = new int[nums.length][nums.length];
        int dp2[][] = new int[nums.length][nums.length];

        // DP stores, row -> nextValue and column -> index, if you are in this index and
        // your nextValue is this i.e. before you the value is nextValue (row) then
        // minimum no. of removals required is how much
        // This value will be similar for whatever be the HighestPeak

        // Changing the Initial Value of these DP array's to -1
        for (int i = 0; i < dp1.length; i++) {
            for (int j = 0; j < dp1[0].length; j++) {
                dp1[i][j] = -1;
            }
        }
        for (int i = 0; i < dp2.length; i++) {
            for (int j = 0; j < dp2[0].length; j++) {
                dp2[i][j] = -1;
            }
        }

        // The Mountain Peak Value can be anything between 1 to nums.length - 2 (First
        // and Last Element cannot be the Peak Value)
        // So, Going through all the possibilities Mountain Peaks
        for (int i = 1; i < nums.length - 1; i++) {
            // System.out.println("Removals Needed: " +
            // minimumMountainRemovalsRecursion(nums, i, dp1, dp2) + " when MountainPeak
            // Choosen = " + i);
            minRemovals = Math.min(minimumMountainRemovalsRecursion(nums, i, dp1, dp2), minRemovals); // To keep track
                                                                                                      // of the minimum
                                                                                                      // removal needed
        }
        System.out.println("Minimal Removal Needed, Using Recursion and Counting Removals: " + minRemovals);

    }

    // Using Recursion along with DP
    public static int minimumMountainRemovalsRecursion(int[] nums, int highestPeak, int dp1[][], int dp2[][]) {
        int nextValue = highestPeak; // The value which is accepted
        // start to highestPeak
        int noOfRemovals1 = startToHighestPeakMinimumRemovals(nums, nextValue, nextValue - 1, highestPeak, dp1);
        // highestPeak to end
        int noOfRemovals2 = highestPeakToEndMinimumRemovals(nums, nextValue, nextValue + 1, highestPeak, dp2);
        return noOfRemovals1 + noOfRemovals2;
    }

    // Calculates Minimum No. oF Removals from Start to the HighestPeak
    public static int startToHighestPeakMinimumRemovals(int nums[], int nextValue, int i, int highestPeak, int dp[][]) {
        if (i < 0 && highestPeak == nextValue) { // Invalid Case i.e. all elements before highestPeak are removed
            return nums.length;
        }
        if (i < 0)
            return 0;

        if (dp[nextValue][i] != -1)
            return dp[nextValue][i];

        // Forced to Remove
        if (nums[nextValue] <= nums[i]) {
            int ans = 1 + startToHighestPeakMinimumRemovals(nums, nextValue, i - 1, highestPeak, dp);
            if (ans >= nums.length) { // If ans has Invalid Case then only it's value get equal to or greater than the
                                      // size of array
                return nums.length;
            }
            return dp[nextValue][i] = ans;
        } else {
            // Remove
            int ans1 = 1 + startToHighestPeakMinimumRemovals(nums, nextValue, i - 1, highestPeak, dp);
            // Not Remove
            int ans2 = startToHighestPeakMinimumRemovals(nums, i, i - 1, highestPeak, dp);
            int ans = Math.min(ans1, ans2);
            if (ans >= nums.length) { // If ans has Invalid Case then only it's value get equal to or greater than the
                                      // size of array
                return nums.length;
            }
            return dp[nextValue][i] = ans;
        }
    }

    //// Calculates Minimum No. oF Removals from HighestPeak to the End
    public static int highestPeakToEndMinimumRemovals(int nums[], int nextValue, int j, int highestPeak, int dp[][]) {
        if (j >= nums.length && highestPeak == nextValue) { // Invalid Case i.e. all elements after highestPeak are
                                                            // removed
            return nums.length;
        }
        if (j >= nums.length)
            return 0;

        if (dp[nextValue][j] != -1)
            return dp[nextValue][j];
        // Forced to Remove
        if (nums[nextValue] <= nums[j]) {
            int ans = 1 + highestPeakToEndMinimumRemovals(nums, nextValue, j + 1, highestPeak, dp);
            if (ans >= nums.length) { // If ans has Invalid Case then only it's value get equal to or greater than the
                                      // size of array
                return ans;
            }
            return dp[nextValue][j] = ans;
        } else {
            // Remove
            int ans1 = 1 + highestPeakToEndMinimumRemovals(nums, nextValue, j + 1, highestPeak, dp);
            // Not Remove
            int ans2 = highestPeakToEndMinimumRemovals(nums, j, j + 1, highestPeak, dp);
            int ans = Math.min(ans1, ans2);
            if (ans >= nums.length) { // If ans has Invalid Case then only it's value get equal to or greater than the
                                      // size of array
                return ans;
            }
            return dp[nextValue][j] = ans;
        }
    }

}
