package Array_2D;

// Write a program to FindTransposeofa Matrix;
public class TranposeOFMatrix {
    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        transpose(arr);
    }

    public static void transpose(int arr[][]) {
        int transpose[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        display(transpose);
    }

    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
