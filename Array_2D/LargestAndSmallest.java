package Array_2D;

import java.util.Scanner;

public class LargestAndSmallest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[3][3];
        System.out.println("Enter the Matrix of 3*3 Size;");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // Search Largest
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("The Maximum Value is: " + max);

        // Search Key
        int key = 4;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Key is present at Index: (" + i + " , " + j + ")");
                }
            }
        }
    }
}
