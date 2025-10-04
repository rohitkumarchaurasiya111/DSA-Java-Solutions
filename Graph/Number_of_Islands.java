//Leetcode - 200 

public class Number_of_Islands{
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        boolean isVisited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    dfsUtil(grid,isVisited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfsUtil(char[][] grid, boolean[][] isVisited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1' || isVisited[i][j]) return;
        isVisited[i][j] = true;

        //Up
        dfsUtil(grid, isVisited, i-1, j);
        //Down
        dfsUtil(grid, isVisited, i+1, j);
        //Left
        dfsUtil(grid, isVisited, i, j-1);
        //Right
        dfsUtil(grid, isVisited, i, j+1);
    }
}