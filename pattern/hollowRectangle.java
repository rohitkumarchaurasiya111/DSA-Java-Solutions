package pattern;

public class hollowRectangle {
    public static void main(String args[]) {
        int row = 4;
        int column = 10;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 || i == row || j == 1 || j == column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
