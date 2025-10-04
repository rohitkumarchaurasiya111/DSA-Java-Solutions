package pattern;

public class butterfly {
    public static void main(String args[]) {
        int lines = 4;

        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 2 * lines - 2 * i; k > 0; k--) { // k = 2*(lines - i)
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // for (int i = 1; i <= lines; i++) {
        // for (int j = lines - i + 1; j > 0; j--) {
        // System.out.print("*");
        // }
        // for (int k = 1; k <= 2 * i - 2; k++) {
        // System.out.print(" ");
        // }
        // for (int j = lines - i + 1; j > 0; j--) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }
        for (int i = lines; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 2 * lines - 2 * i; k > 0; k--) { // k = 2*(lines - i)
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
