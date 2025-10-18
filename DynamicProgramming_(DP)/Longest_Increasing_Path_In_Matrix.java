// Leetcode 329 - Longest Incresing Path in a Matrix
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).


public class Longest_Increasing_Path_In_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {7, 6, 1, 1},
            {2, 7, 6, 0},
            {1, 3, 5, 1},
            {6, 6, 3, 2}
        };
        longestIncreasingPath(matrix);
    }


    public static void longestIncreasingPath(int[][] matrix) {
       
        //Using Recursion
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ans = longestIncreasingPathRecursion(matrix, i,j);      //To see that all the points can be the starting point
                max = Math.max(max, ans);
            }
        }
        System.out.println("Using Recursion: " + max);


        //Using Memoization in DP
        int dp[][] = new int[matrix.length][matrix[0].length];
        max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ans = longestIncreasingPathMemoization(matrix, i,j,dp);      //To see that all the points can be the starting point
                max = Math.max(max, ans);
            }
        }
        System.out.println("Using Memoization in DP: " + max);
    }


    //Using Recursion
    public static int longestIncreasingPathRecursion(int[][] matrix, int i, int j){
        if(!isSafe(matrix,i,j)) return 0;      //Base Case
        //Looking through all possible moves
        int ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0;
        //Left
        if(isSafe(matrix, i,j-1) && matrix[i][j] < matrix[i][j-1])      //Only call if it's safe and the new cell value is > old cell value
            ans1 = longestIncreasingPathRecursion(matrix, i, j-1);
        //Right
        if(isSafe(matrix, i,j+1) && matrix[i][j] < matrix[i][j+1])      //Only call if it's safe and the new cell value is > old cell value
            ans2 = longestIncreasingPathRecursion(matrix, i, j+1);
        //Up
        if(isSafe(matrix, i-1,j) && matrix[i][j] < matrix[i-1][j])      //Only call if it's safe and the new cell value is > old cell value
            ans3 = longestIncreasingPathRecursion(matrix, i-1, j);
        //Down
        if(isSafe(matrix, i+1,j) && matrix[i][j] < matrix[i+1][j])      //Only call if it's safe and the new cell value is > old cell value
            ans4 = longestIncreasingPathRecursion(matrix, i+1,j);
        return 1 + Math.max(ans1, Math.max(ans2,Math.max(ans3,ans4)));
    }


    //Helper function
    public static boolean isSafe(int[][] matrix, int i, int j){     //To check if it to save to move to this step or not
        if(i<0 || i >= matrix.length || j<0 || j >= matrix[0].length) return false;
        return true;
    }


    //Using Memoization in DP
    public static int longestIncreasingPathMemoization(int[][] matrix, int i, int j, int dp[][]){
        if(!isSafe(matrix,i,j)) return 0;      //Base Case
        if(dp[i][j] != 0) return dp[i][j];  //if value is already present no need to calculate again


        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};  //These are the valid moves
        int maxValueFromAllMoves = 0;
        for (int k = 0; k < dir.length; k++) {          //We will find the values by moving in all the directions
            int nextI = i + dir[k][0];
            int nextJ = j + dir[k][1];
            if(isSafe(matrix, nextI,nextJ) && matrix[i][j] < matrix[nextI][nextJ]){         //Only call if it's safe and the new cell value is > old cell value
                int value = longestIncreasingPathMemoization(matrix, nextI, nextJ, dp);
                maxValueFromAllMoves = Math.max(maxValueFromAllMoves, value);
            }
        }
        return dp[i][j] = 1 + maxValueFromAllMoves;
    }
}
