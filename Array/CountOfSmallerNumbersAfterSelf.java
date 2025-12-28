package Array;

//Leetcode 315. Count of Smaller Numbers After Self
//Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
//Prerequisite - Merge Sort Algorithm
//Here, we will be modifing Merge Step for this specific question
//Merge Part in MergeSort changes the actual position. So, Using index array to store the actual initial positions of the numbers.

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int nums[] = { 5, 2, 6, 1 };
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        // indices array tracks the original index of each element.
        // This allows us to update the 'count' array even as elements are "moved"
        // during sorting.
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, 0, n - 1, count, indices);

        // Convert the result array to a List as required by the LeetCode signature
        List<Integer> list = new ArrayList<>();
        for (int c : count) {
            list.add(c);
        }
        return list;
    }

    /**
     * Standard Divide and Conquer: Splits the array until single elements remain.
     */
    private static void mergeSort(int[] arr, int start, int end, int[] count, int[] indices) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid, count, indices);
        mergeSort(arr, mid + 1, end, count, indices);

        merge(arr, start, mid, end, count, indices);
    }

    /**
     * Merge step that calculates how many elements from the right subarray
     * are smaller than elements from the left subarray.
     */
    private static void merge(int[] arr, int start, int mid, int end, int[] count, int[] indices) {
        int[] temp = new int[end - start + 1];
        int i = start; // Pointer for left subarray
        int j = mid + 1; // Pointer for right subarray
        int k = 0; // Pointer for temp array

        // rightCounter tracks how many elements from the right side have been
        // moved to the merged array before an element from the left side.
        int rightCounter = 0;

        while (i <= mid && j <= end) {
            // Compare elements using their original indices
            if (arr[indices[j]] < arr[indices[i]]) {
                // If the right element is smaller, it's a "smaller number after self"
                // for all remaining elements in the left subarray.
                temp[k++] = indices[j++];
                rightCounter++;
            } else {
                // If the left element is smaller or equal, we finalize its count.
                // It is greater than all the right-side elements we've skipped so far.
                count[indices[i]] += rightCounter;
                temp[k++] = indices[i++];
            }
        }

        // Finalize counts for any remaining elements in the left subarray.
        // These elements are greater than all elements moved from the right subarray.
        while (i <= mid) {
            count[indices[i]] += rightCounter;
            temp[k++] = indices[i++];
        }

        // Copy remaining elements from the right subarray (no count update needed)
        while (j <= end) {
            temp[k++] = indices[j++];
        }

        // Copy sorted indices back into the main indices array
        for (k = 0; k < temp.length; k++) {
            indices[start + k] = temp[k];
        }
    }
}
