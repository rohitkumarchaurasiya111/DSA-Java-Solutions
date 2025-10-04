package Array;
// We use this algo to find Max Subarry Sum 

// It is fast as time complexity is 0(n);
// Here, We take current sum and Max Sum 
// When current sum is -ve then we consider it as 0

public class KadanesAlgorithm {
    public static void main(String args[]) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                check = 1;
            }
        }
        if (check == 1) {
            kadanepositive(arr);
        } else {
            kadanenegative(arr);
        }

    }

    public static void kadanepositive(int arr[]) {
        int max = Integer.MIN_VALUE;
        int current_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            current_sum += arr[i];
            if (current_sum < 0) {
                current_sum = 0;
            }
            // if (current_sum > max) {
            // max = current_sum;
            // }
            max = Math.max(current_sum, max);
        }
        System.out.println("The Max Sum is: " + max);
    }

    public static void kadanenegative(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The Max Sum is: " + max);
    }
}
