package Array;

//Leetcode 1838. Frequency of the Most Frequent Element
// The frequency of an element is the number of times it occurs in an array.
// You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
// Return the maximum possible frequency of an element after performing at most k operations.

// Input: nums = [1,2,4], k = 5
// Output: 3
// Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
// 4 has a frequency of 3.

import java.util.Arrays;

public class Frequency_of_Most_Frequent_Element {
    public static void main(String[] args) {
        // int nums[] = {1,2,4}; //Output - 3
        // int nums[] = {1,4,8,13}; //output - 2
        // int k = 5;

        int nums[] = { 7, 1, 5, 5 }; // Output - 2
        int k = 2;
        System.out.println(maxFrequency(nums, k));
    }

    // Using the concept of sliding window
    public static int maxFrequency(int[] nums, int k) {
        // Sort the Elements so that the difference between two consecutive elements
        // will be minimum
        Arrays.sort(nums);

        int maxFreq = 1; // To store the maximum Frequency possible
        int left = 0, right = 1; // Two pointers for sliding windows

        int sum = nums[0]; // Sum to store the sum of elements inside the window, Initially, Sum = first
                           // element

        for (right = 1; right < nums.length; right++) { // The right side will begin from 2nd element till the last

            // Vlaid Condition is only when our window containing all elements can be made
            // similar to the highest element in the window (i.e. right side number)
            while ((long) ((long) ((right - left) * nums[right]) - sum) > k) { // Increment left side until valid
                                                                               // condition comes
                sum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1); // In valid condition, Finding Frequency and updating
                                                           // maxFrequency if it is bigger

            sum += nums[right]; // Adding new element of our window into the sum so that we can use this sum on
                                // nextIteration to find the valid condition
        }
        return maxFreq;
    }
}
