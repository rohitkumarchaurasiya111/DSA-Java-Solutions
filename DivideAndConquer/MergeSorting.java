package DivideAndConquer;

public class MergeSorting {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 9, 0, -5, 3, 24, 1, 5 };
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void mergeSort(int arr[], int si, int ei) {
        int mid = si + (ei - si) / 2;
        if (si >= ei) {
            return;
        }
        // Left part
        mergeSort(arr, si, mid);
        // Right Part
        mergeSort(arr, mid + 1, ei);
        // Merges the parts again 
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // Temp values are given to arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
}
