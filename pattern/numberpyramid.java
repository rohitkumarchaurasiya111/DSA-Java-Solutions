package pattern;

public class numberpyramid {
    public static void main(String args[]) {
        int lines = 5;
        for (int i = 1; i <= lines; i++) {
            for (int j = lines - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
