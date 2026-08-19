package Recursion;

public class TilingProblem {
    public static void main(String args[]) {
        int n = 5;
        System.out.println(tiles_count(n));
    }
 
    public static int tiles_count(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // Horizontal
        int hor_count = tiles_count(n - 2);

        // Vertical;
        int ver_count = tiles_count(n - 1);

        return (hor_count + ver_count);
    }
}
