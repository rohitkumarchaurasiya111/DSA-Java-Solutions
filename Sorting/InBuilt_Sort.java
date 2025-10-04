package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class InBuilt_Sort {
    public static void main(String args[]) {

        // Sort in Ascending Order
        int arr[] = { 2, -4, 9, 6, 11, 3 };
        Arrays.sort(arr);
        display(arr);
        int arr1[] = { 2, -4, 9, 6, -5, 3 };
        Arrays.sort(arr1, 1, 4);
        display(arr1);

        // Sorting in Descending order
        Integer arr2[] = { 2, -4, 9, 6, -5, 3 };
        Arrays.sort(arr2, Collections.reverseOrder());
        display(arr2);
        //Arrays.sort(arr2,0,4,Collections.reverseOrder()); - This will sort form 0 to 3 in descending order 
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void display(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
