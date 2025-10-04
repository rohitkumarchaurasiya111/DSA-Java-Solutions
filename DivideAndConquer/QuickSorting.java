package DivideAndConquer;

public class QuickSorting {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 9, 0, -5, 3, 24, 1, 5 };
        QuickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void QuickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivot = partition(arr, si, ei);
        QuickSort(arr, si, pivot - 1);
        QuickSort(arr, pivot + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int k = si - 1;
        for (int i = si; i < ei; i++) {
            if (arr[i] <= pivot) {
                k++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        k++;
        int temp = pivot;
        arr[ei] = arr[k];
        arr[k] = temp;
        return k;
    }
}
