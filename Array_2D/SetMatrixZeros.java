package Array_2D;

//Leetcode -  73. Set Matrix Zeros

class SetMatrixZeros {

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(arr);
    }

    public static void setZeroes(int[][] matrix) {
        // Here, We are choosing the first row and the first column as the flag, that
        // will tell if that specific column or row needs to be converted to zero or
        // not.

        // These variables will track if our choosen Row and columns contains zero
        // initially, if yes we will have to make these row or columns also zero
        boolean choosenRowContainsZero = false;
        boolean choosenColumnContainsZero = false;

        // Using the first cell of the row and the column to store if that specific row
        // or column needs to be set to zero or not
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        choosenRowContainsZero = true; // if our choosen row contains zero
                    if (j == 0)
                        choosenColumnContainsZero = true; // if our choosen column contains zero
                    // If any other place contains zero
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Based on the value of the First row and column setting all other columns to
        // zero (if needed)
        // Below code will only change the other row and columns except the first one
        // which we have used as the flags
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // If choosen row contains zero intially, then we have to make that row zero
        if (choosenRowContainsZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        // If choosen column contains zero intially, then we will have to make that
        // column zero
        if (choosenColumnContainsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
