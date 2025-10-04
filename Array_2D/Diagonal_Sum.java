package Array_2D;

public class Diagonal_Sum {
    public static void main(String args[]) {
        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        int arr[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        int sum_primary_Diagonal = 0;
        int sum_secondary_Diagonal = 0;
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // if (i == j) {
        // sum_primary_Diagonal += arr[i][j];
        // }
        // else if (i + j == arr.length - 1) {
        // sum_secondary_Diagonal += arr[i][j];
        // }
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            sum_primary_Diagonal += arr[i][i];
            if (i != arr.length - 1 - i) {
                sum_secondary_Diagonal += arr[i][arr.length - 1 - i];
            }
        }
        // this is done one if we don't keep if condition in loop 
        // int total = 0;
        // if (arr.length % 2 == 0) {
        //     total = sum_primary_Diagonal + sum_secondary_Diagonal;
        // } else {
        //     int i = (arr.length - 1) / 2;
        //     total = sum_primary_Diagonal + sum_secondary_Diagonal - arr[i][i];
        // }
        int total = sum_primary_Diagonal + sum_secondary_Diagonal;
        System.out.println(total);
    }
}
