package Array_2D;

// Print out the sum of the numbers inthe second row of the “nums” array
public class SumofRow {
    public static void main(String args[]) {
        int arr[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        SumOFRow(arr, 1);
    }

    public static void SumOFRow(int arr[][], int row) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == row) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("THe sum is: " + sum);
    }
}
