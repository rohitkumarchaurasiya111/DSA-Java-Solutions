package Recursion;

public class CheckArraySorted {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 99, 4, 5 };
        System.out.println(check_sorted(arr, 0));
    }

    public static boolean check_sorted(int arr[], int i) {
        if (arr.length - 1 == i) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return check_sorted(arr, i + 1);
    }
}
