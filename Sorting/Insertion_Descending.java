package Sorting;

public class Insertion_Descending {
    public static void main(String args[]) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && (current > arr[prev])) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
