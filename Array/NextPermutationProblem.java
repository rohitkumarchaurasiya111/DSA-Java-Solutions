package Array;

//Leetcode - 31, Next Permutation
import java.util.*;

public class NextPermutationProblem {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 3, 3 };
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        // Iterate From last and Find an elements that contradicts the descending order
        int noNotFollowingDescendingOrder = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                noNotFollowingDescendingOrder = i - 1;
                break;
            }
        }
        if (noNotFollowingDescendingOrder == -1) { // It means the array is in descending order completely
            // So, We will have to reverse the whole array
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int minNoMoreThanChoosenNo = noNotFollowingDescendingOrder + 1;
            // Find a number that is just greater than our choosen number and is in our
            // right side. So, that even if i go there, the descending order will still get
            // followed
            for (int i = noNotFollowingDescendingOrder + 1; i < nums.length; i++) {
                if (nums[i] > nums[noNotFollowingDescendingOrder] && nums[minNoMoreThanChoosenNo] >= nums[i]) {
                    minNoMoreThanChoosenNo = i;
                }
            }
            // Swap both numbers
            int temp = nums[noNotFollowingDescendingOrder];
            nums[noNotFollowingDescendingOrder] = nums[minNoMoreThanChoosenNo];
            nums[minNoMoreThanChoosenNo] = temp;

            // Reverse all the values that are after my new choosen number
            reverseArray(nums, noNotFollowingDescendingOrder + 1, nums.length - 1);
        }
    }

    public static void reverseArray(int arr[], int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            int temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}
