//Leetcode 1254. Number of Closed Islands

public class Number_of_Closed_Island {
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,1,1,1,1,1,0},
            {1,0,0,0,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0}
        };
        System.out.println(closedIsland(grid));
    }
    public static int closedIsland(int[][] grid) {
        boolean isVisited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && !isVisited[i][j]){
                    if(dfsUtil(grid, isVisited, i, j)) count++;
                }
            }
        }
        return count;
    }

    static boolean dfsUtil(int[][] grid, boolean[][] isVisited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if(grid[i][j] == 1 || isVisited[i][j]) return true;
        isVisited[i][j] = true;
        // Explore 4 directions
        boolean up = dfsUtil(grid, isVisited, i - 1, j);
        boolean down = dfsUtil(grid, isVisited, i + 1, j);
        boolean left = dfsUtil(grid, isVisited, i, j - 1);
        boolean right = dfsUtil(grid, isVisited, i, j + 1);

        return up && down && left && right;
    }
}
