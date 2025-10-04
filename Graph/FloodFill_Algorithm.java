import java.util.Arrays;

public class FloodFill_Algorithm {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean isVisited[][] = new boolean[image.length][image[0].length]; //It is necessary when color = originalValue of Pixels
        helper(image, sr, sc, color, image[sr][sc], isVisited);
        return image;
    }

    public static void helper(int[][] image, int r, int c, int color, int originalValue, boolean isVisited[][]) {
        //Base Cases
        if(r < 0 || c < 0|| r > image.length-1 || c > image[0].length-1 || isVisited[r][c] || image[r][c] != originalValue)
            return;
        image[r][c] = color;
        isVisited[r][c] = true;
        //Possible Moves
        //Up
        helper(image, r-1, c, color, originalValue, isVisited);
        //Down
        helper(image, r+1, c, color, originalValue, isVisited);
        //Left
        helper(image, r, c-1, color, originalValue, isVisited);
        //Right
        helper(image, r, c+1, color, originalValue, isVisited);
    }

    public static void main(String[] args) {
        int image[][] = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(floodFill(image,sr,sc,color)));
    }
}
