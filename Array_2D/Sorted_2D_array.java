package Array_2D;

public class Sorted_2D_array {
    public static void main(String args[]) {
        int arr[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int target = 45;

        System.out.println(search(arr, target));
    }

    public static boolean search(int arr[][], int target) {
        // Stair-Case Searching Approach - 0(m+n);

        // Taking arr[0][arr.length - 1] as initial block to check
        // int i = 0; // row
        // int j = arr.length - 1; // column
        // while (i < arr.length && j >= 0) {
        // if (arr[i][j] == target) {
        // return true;
        // } else if (target > arr[i][j]) {
        // i++;
        // } else if (target < arr[i][j]) {
        // j--;
        // }
        // }
        // return false;

        // Taking arr[arr.lenth-1][0] as initial block
        int i = arr.length - 1;
        int j = 0;
        while (i >= 0 && j < arr.length) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

}
