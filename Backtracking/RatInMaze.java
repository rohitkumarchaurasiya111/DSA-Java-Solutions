package Backtracking;

//Rat in a Maze
// You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a square matrix of order N N where the cells with value 0 represent the maze's blocked locations while value 1 is the open/available path that the rat can take to reach its destination. The rat's destination is at (N - 1, N-1).
// Your task is to find all the possible paths that the rat can take to reach from source to destination in the maze.
// The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y - 1), 'D'(down) i.e. (x, y + 1), 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).

public class RatInMaze {
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int solution[][] = new int[maze.length][maze[0].length]; // It contains solution path

        if (rat_steps(maze, 0, 0, "", solution)) {
            solution[0][0] = 1;
            System.out.println("Solution Exits:");
            print(solution);
        } else {
            System.out.println("Solution Doesnot Exist");
        }

    }

    public static boolean rat_steps(int maze[][], int row, int col, String path, int solution[][]) {
        // Base
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            solution[row][col] = 1;
            System.out.println("Path Followed is: " + path);
            // print(solution);
            return true;
        }

        // Right
        if (isSafe(maze, row, col + 1)) {
            solution[row][col + 1] = 1;
            if (rat_steps(maze, row, col + 1, path + "R", solution)) {
                return true;
            }

        }
        // Down
        if (isSafe(maze, row + 1, col)) {
            solution[row + 1][col] = 1;
            if (rat_steps(maze, row + 1, col, path + "D", solution)) {
                return true;
            }
        }
        // solution[row][col] = 0;
        return false;
    }

    public static boolean isSafe(int maze[][], int row, int col) {
        if (row >= maze.length || col >= maze[0].length || maze[row][col] == 0) {
            return false;
        }
        return true;
    }

    public static void print(int solution[][]) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
    }

}
