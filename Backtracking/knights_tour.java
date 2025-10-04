package Backtracking;

//Knight's Tour
// Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess, knights must visit each square exactly once. Print the order of each cell in which they are visited.

public class knights_tour {
    public static void main(String[] args) {
        int n = 8;
        int arr[][] = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = -1;
            }
        }
        arr[0][0] = 0;

        int x_move[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int y_move[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        System.out.println("start");
        if (knight_travelling(arr, 0, 0, 1, x_move, y_move)) {
            print(arr);
        } else {
            System.out.println("Solution Doesnot Exist");
        }

    }

    static boolean knight_travelling(int arr[][], int row, int col, int step, int x_move[], int y_move[]) {
        if (step == arr.length * arr.length) {
            // print(arr);
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int next_row = row + x_move[i];
            int next_col = col + y_move[i];
            if (isSafe(next_row, next_col, arr)) {
                arr[next_row][next_col] = step;
                if (knight_travelling(arr, next_row, next_col, step + 1, x_move, y_move)) {
                    return true;
                } else {
                    arr[next_row][next_col] = -1;
                }
            }
        }

        return false;

    }

    static boolean isSafe(int row, int col, int arr[][]) {
        if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == -1) {
            return true;
        }
        return false;
    }

    static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
