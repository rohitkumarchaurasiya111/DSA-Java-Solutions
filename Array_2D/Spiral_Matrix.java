package Array_2D;

public class Spiral_Matrix {
    public static void main(String args[]) {
        int spiral[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int row = spiral.length;
        int column = spiral[0].length;
        int End_row = row - 1;
        int Start_row = 0;
        int Start_column = 0;
        int End_column = column - 1;

        while (Start_row <= End_row && Start_column <= End_column) {
            for (int j = Start_row; j <= End_column; j++) {
                System.out.print(spiral[Start_row][j] + " ");
            }
            for (int i = Start_column + 1; i <= End_row; i++) {
                System.out.print(spiral[i][End_column] + " ");
            }
            for (int j = End_column - 1; j >= Start_column; j--) {
                if (Start_row == End_row) {
                    break;
                }
                System.out.print(spiral[End_row][j] + " ");
            }
            for (int i = End_row - 1; i > Start_row; i--) {
                if (Start_column == End_column) {
                    break;
                }
                System.out.print(spiral[i][Start_column] + " ");
            }
            Start_column++;
            Start_row++;
            End_column--;
            End_row--;
        }

    }

}
