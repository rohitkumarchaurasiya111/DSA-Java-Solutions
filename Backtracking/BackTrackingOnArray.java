package Backtracking;

public class BackTrackingOnArray {
    public static void main(String args[]) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }

    public static void changeArr(int arr[], int i, int value) {
        //Base Case 
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        //Kaam 
        arr[i] = value;
        changeArr(arr, i+1, value+1);
        arr[i] = value - 2;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
