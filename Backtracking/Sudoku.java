package Backtracking;
//Author :- Rohit Kumar Chaurasiya

//Time :- 2024/07/24 3:04 pm 

//Write a function to solve a sudoku

public class Sudoku {
    public static void main(String[] args) {
        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        sudoku_solver(sudoku, 0, 0);
        print(sudoku);
    }

    // Here, We first keep a value from 1 to 9 using loop at first place and check
    // if it is safe or not. If it is safe then we call the loop for second place
    // and does the same. If at any place it returns false then we do the
    // coressponding entry 0

    static boolean sudoku_solver(int sudoku[][], int row, int col) {
        // Base Case
        if (row == 9 && col == 0) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (nextCol >= 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudoku_solver(sudoku, nextRow, nextCol);
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (sudoku_solver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    // This function checks if it is allowed to keep the number in this specific
    // place or not
    static boolean isSafe(int sudoku[][], int row, int col, int value) {
        // Check value present in column or not
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        // Check value present in row or not
        for (int j = 0; j < sudoku.length; j++) {
            if (sudoku[row][j] == value) {
                return false;
            }
        }

        // Check if present in that box or not
        int s_row = (row / 3) * 3;
        int s_col = (col / 3) * 3;
        for (int i = (s_row); i < (s_row + 3); i++) {
            for (int j = (s_col); j < (s_col + 3); j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        // If that particular number is not present any where
        return true;
    }

    static void print(int sudoku[][]) {
        System.out.println("------Sudoku-----");
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
