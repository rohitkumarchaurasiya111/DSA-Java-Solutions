package Sorting;

public class Insertion_Sort {
    public static void main(String args[]) {
        int arr[] = { 2, -4, 9, 6, 11, 3 };
        for (int i = 1; i < arr.length; i++) {
            int current_element = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current_element) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current_element;
        }
        System.out.println("Sorted list is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
