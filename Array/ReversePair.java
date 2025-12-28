package Array;

//Leetcode 493. Reverse Pairs
// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:
// 0 <= i < j < nums.length and nums[i] > 2 * nums[j].    

class ReversePair {
    public static void main(String[] args) {
        int nums[] = { -5, -5 };
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * Standard Merge Sort structure modified to count reverse pairs.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n) due to the temporary array in merge
     */
    private static int mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return 0;

        int mid = start + (end - start) / 2;
        int count = 0;

        // 1. Recursively find reverse pairs in the left and right halves
        count += mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);

        // 2. Count "cross-pairs" (where i is in the left half and j is in the right
        // half)
        // This MUST be done before merging, while the two halves are individually
        // sorted.
        count += countPairs(nums, start, mid, end);

        // 3. Merge the two sorted halves back together
        merge(nums, start, mid, end);

        return count;
    }

    /**
     * Counts pairs (i, j) such that start <= i <= mid, mid < j <= end
     * and nums[i] > 2 * nums[j].
     */
    private static int countPairs(int[] nums, int start, int mid, int end) {
        int count = 0;
        int j = mid + 1;

        // Using Two-Pointer technique:
        // Since both halves are sorted, as 'i' increases, the required 'j' only moves
        // forward.
        for (int i = start; i <= mid; i++) {
            // Check condition using long to prevent integer overflow
            while (j <= end && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            // All elements from (mid + 1) to (j - 1) satisfy the condition for the current
            // nums[i]
            count += (j - (mid + 1));
        }
        return count;
    }

    /**
     * Standard merge operation to combine two sorted subarrays.
     */
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start; // Pointer for left half
        int j = mid + 1; // Pointer for right half
        int k = 0; // Pointer for temp array

        // Standard merge logic
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements from left side
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements from right side
        while (j <= end) {
            temp[k++] = nums[j++];
        }

        // Transfer sorted elements from temp back to original array
        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }
}
