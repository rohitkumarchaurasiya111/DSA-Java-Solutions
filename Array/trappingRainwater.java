package Array;

public class trappingRainwater {
    public static void main(String args[]) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int rightMax = 0;
        int leftMax = 0;
        int height = 0;
        for (int i = 0; i < arr.length; i++) {
            rightMax = max(arr, i, arr.length - 1);
            leftMax = max(arr, 0, i);
            int Min = Math.min(leftMax, rightMax);
            // if (Min > arr[i]) {
            height += (Min - arr[i]);
            // }
        }
        System.out.println("The volume of water Trapped is: " + height);

    }

    public static int max(int arr[], int i, int j) {
        if (i == j) {
            // return 0;
            return arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            if (arr[k] > max) {
                max = arr[k];
            }
        }

        return max;
    }
}
