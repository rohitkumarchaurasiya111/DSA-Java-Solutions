package DivideAndConquer;

public class SearchINsortedAndRotatedArray {
    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search_rec(arr, target, 0, arr.length - 1));
    }

    // Here, Recursion is used
    public static int search_rec(int arr[], int target, int si, int ei) {
        int mid = si + (ei - si) / 2;
        if (si > ei) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] >= arr[si]) {
            if ((target >= arr[si]) && (target < arr[mid])) {
                return search_rec(arr, target, si, mid - 1);
            } else {
                return search_rec(arr, target, mid + 1, ei);
            }
        } else {
            if ((target <= arr[ei]) && (target > arr[mid])) {
                return search_rec(arr, target, mid + 1, ei);
            } else {
                return search_rec(arr, target, si, mid - 1);
            }
        }

    }

    // Here, Itteration is used
    public static int search(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            // Mid on Line 1
            if (arr[start] <= arr[mid]) {
                if ((arr[mid] > target) && (arr[start] <= target)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Mid on Line 2
            else {
                if ((arr[mid] < target) && (arr[end] >= target)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
