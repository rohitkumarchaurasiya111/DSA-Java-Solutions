package DivideAndConquer;
// Given an array nums of size n, returnthe majority element. 

public class MajorityElement {
    public static void main(String args[]) {
        int arr[] = { 8, 8, 7, 7, 7 };
        System.out.println(majority_element(arr, 0, arr.length - 1));

    }

    public static int majority_element(int arr[], int si, int ei) {
        if (si == ei) {
            return arr[si];
        }
        int mid = si + (ei - si) / 2;
        int left_major = majority_element(arr, si, mid);
        int right_major = majority_element(arr, mid + 1, ei);
        if (left_major == right_major) {
            return left_major;
        }

        int left_count = count(arr, si, ei, left_major);
        int right_count = count(arr, si, ei, right_major);

        return left_count > right_count ? left_major : right_major;

    }

    public static int count(int arr[], int si, int ei, int num) {
        int count = 0;
        for (int i : arr) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }
}
