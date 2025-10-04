package Backtracking;
//Author: Rohit Kumar Chaurasiya

//Time: 2024/07/22 11:00 pm

//Place N queens on an NxN chessboard such that no 2 queens can attack each other

//Here, Each queen will be in each row. So, We will keep first queen in first row and first column and then check for 2nd queen by keeping in second row that if it is possible to keep it somewhere in second row or not. If not possible then we will keep the previous queen at another position and again do the same process until we get the result 

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char arr[][] = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '*';
            }
        }

        queens(arr, 0);
        System.out.println("Solutions Possible are: " + count);
        // print(arr);
    }

    static int count = 0; // Counts the number of possible solutions

    // This function places the queen on the board
    public static void queens(char arr[][], int row) {
        // Base Case - If row is equals to arr.length then we won i.e. All Queens placed
        // successfully at all rows
        if (row == arr.length) {
            count++;
            print(arr);
            return;
        }

        // Columns to place queen at
        for (int i = 0; i < arr.length; i++) {

            if (isSafe(arr, row, i)) { // Checks if it is safe to place the queen or not
                arr[row][i] = 'Q'; // Keeps the queen
                queens(arr, row + 1); // Calls function for another row to keep the queen
                arr[row][i] = '*'; // Remove the queen from previous position so that it can be placed on another
                                   // position

                // For only one solution
                // if (queens(arr, row + 1)) {
                // return true;
                // }
                // arr[row][i] = '*';
                // For this, we need to make function return type boolean
            }
        }
        // return false;
    }

    // This checks if it is good to keep the queen at this specific position or not
    public static boolean isSafe(char arr[][], int row, int col) {
        // Vertical Up - If another queen is present in vertical up then it is not safe
        // to keep so returns false
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        // Diagonal Left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal Right
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        return true; // As not queen is at up, right or left. So, it is safe to keep the queen
    }

    public static void print(char arr[][]) {
        System.out.println("---Chess Board---");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
