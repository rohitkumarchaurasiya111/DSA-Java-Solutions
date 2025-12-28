package Array;

//Leetcode 15. 3Sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.

import java.util.*;

class ThreeSum {

    public static void main(String[] args) {
        int num[] = { -4, -1, -1, 0, 1, 2 };
        System.out.println(threeSum(num));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Sorting the Array, so that We can use two pointer concept

        for (int i = 0; i < nums.length - 2; i++) {
            int choosenNum = nums[i]; // Choosing the current Element
            int left = i + 1; // Left pointer
            int right = nums.length - 1; // right pointer
            if ((i - 1) >= 0 && nums[i - 1] == nums[i])
                continue; // if previous number was also same, then skip current number as previous number
                          // would have covered all the scenarios that curr will cover
            if (nums[i] > 0)
                break; // Choosen number should always be negative, then only we can have posibility of
                       // 0 as final sum, as other 2 numbers will be bigger than this

            while (left < right) {
                int total = nums[left] + nums[right] + nums[i];
                if (total == 0) {
                    // Add into the result
                    result.add(Arrays.asList(choosenNum, nums[left], nums[right]));

                    // Skipping same numbers. So that we don't get same result again
                    while ((left < right) && nums[left] == nums[left + 1])
                        left++;
                    while ((left < right) && nums[right] == nums[right - 1])
                        right--;
                    left++; // Pointing to next numbers to see if this can get to our result or not
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
