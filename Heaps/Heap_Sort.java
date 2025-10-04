package Heaps;

public class Heap_Sort {
    // For Sorting in Asecending Order
    static void Sort(int arr[]) {
        // Create Max Heap
        for (int i = arr.length / 2; i >= 0; i--) {
            Heapify(i, arr, arr.length - 1);
        }

        // Swap root with last element and decrease the size by 1
        for (int i = arr.length - 1; i > 0; i--) { // This for loop automatically decreases the size by 1
            // Swap
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Heapify the root as it is swapped and now it is not maxHeap
            Heapify(0, arr, i - 1);
        }
    }

    static void Heapify(int i, int arr[], int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;

        if (left <= size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right <= size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;

            Heapify(maxIndex, arr, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 8, 2, 4, -5, 2, 8, -7, 13 };
        Sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
