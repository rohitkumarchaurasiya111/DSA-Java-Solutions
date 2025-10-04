package pattern;

public class HollowRhombuss {
    public static void main(String args[]) {
        int lines = 10;
        for (int i = 1; i <= lines; i++) {
            for (int j = lines - 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= lines; j++) {
                if (i == 1 || i == lines || j == 1 || j == lines) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
