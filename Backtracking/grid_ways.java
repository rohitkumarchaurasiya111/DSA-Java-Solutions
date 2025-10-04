package Backtracking;
//Author: Rohit Kumar Chaurasiya
//Time : 2024/07/23 9:18am
//Find number of ways to reach from (0,0) to (N-1, M-1) in a NxM Grid. Allowed moves - right or down.

/* Here, we give base cases as if pos_x == n-1 and pos_y == m-1 i.e. we are at final position then way is 1 as we are already there and if we go outside the bounday then we return. Here, we first find right_ways and then left_ways and at last we add both to find the total ways. */

public class grid_ways {
    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        System.out.println(ways(n, m, 0, 0));
        System.out.println(trick_ways(n, m, 0, 0));
    }

    public static int ways(int row, int col, int pos_x, int pos_y) {
        // base case
        if (pos_x == row - 1 && pos_y == col - 1) {
            return 1;
        } else if (pos_x == row || pos_y == col) {
            return 0;
        }

        // Work
        // Right - Calculate ways from right
        int right_way = ways(row, col, pos_x + 1, pos_y);
        // Down - Calculate ways from down
        int down_way = ways(row, col, pos_x, pos_y + 1);
        return right_way + down_way;
    }


    //It is mathematical trick used to solve this problem in linear time. We use permutation here. when we have 4 rows and 3 columns then we can move 3R and 2D positions if we are at (0,0) and total steps to move will be 5 steps. so we use permutation here as 5!/3!*2!;
    public static int trick_ways(int row, int col, int pos_x, int pos_y) {
        int way = 0;
        way = fact(row - 1 + col - 1) / (fact(row - 1 - pos_x) * fact(col - 1 - pos_y));
        return way;
    }

    public static int fact(int num) { //It is used to calculate factorial 
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
