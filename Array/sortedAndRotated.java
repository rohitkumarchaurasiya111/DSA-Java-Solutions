package Array;
// There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  such  that  the  resulting  array  is [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   For   example, [0,1,2,4,5,6,7] might        be        rotated        at        pivot        index 3   and become [4,5,6,7,0,1,2].Given the array nums after the possible rotation and an integer target, returnthe index oftarget if it is in nums, or -1   if it is not in nums.You must write an algorithm with O(log n) runtime complexity.

public class sortedAndRotated {
    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int pivot = pivot(arr);
        int index = -1;
        if (target <= arr[pivot] && target >= arr[0]) {
            index = binary_search(arr, 0, pivot, target);
        } else {
            index = binary_search(arr, pivot + 1, arr.length - 1, target);
        }
        if (index == -1) {
            System.out.println("The Given Number " + target + " is not Present!");
        } else {
            System.out.println("The Given Number " + target + " is Present at Index " + index);
        }

    }

    public static int pivot(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = end - (end - start) / 2;
            if (arr[middle] > arr[middle + 1]) {
                return middle;
            } else if (arr[middle] < arr[0]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int binary_search(int arr[], int start, int end, int target) {
        while (start <= end) {
            int middle = end - (end - start) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
