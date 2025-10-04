package Sorting;

public class Selection_Sort {
    public static void main(String args[]) {
        int arr[] = { -99, 2, 9, 0, -5, 99, 4 };

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
