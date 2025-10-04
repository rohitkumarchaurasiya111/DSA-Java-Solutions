package DivideAndConquer;

public class Inversion_count {
    static int count = 0;

    public static void main(String args[]) {
        int arr[] = { 2, 4, 1, 3, 5 };
        System.out.println(count_inversion(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(count + "\n\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Optimized Method
    // Merge Sort is used here
    public static void mergeSort(int arr[], int si, int ei) {
        if (si == ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, ei, mid);
    }

    public static void merge(int arr[], int si, int ei, int mid) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[ei - si + 1];
        while (i <= mid && j <= ei) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                k++;
                count += (mid) - i + 1;
                j++;
            } else {
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= ei) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (i = si, k = 0; i < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // It is a Brute Force Method.
    public static int count_inversion(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (num > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
