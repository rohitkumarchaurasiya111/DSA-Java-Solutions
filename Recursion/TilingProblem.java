package Recursion;

/*Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile the given board using the 2 x 1 tiles.
(A tile can either be placed horizontally or vertically.) 
Author:- Rohit Kumar Chaurasiya
Date:- 2024/07/17 10:58 AM */

public class TilingProblem {
    public static void main(String args[]) {
        int n = 4;
        System.out.println(no_of_ways_tiles_can_be_kept(n));
    }

    // This function finds out the number of ways the tiles can be placed
    public static int no_of_ways_tiles_can_be_kept(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // we have two choices either to place the tiles horizontally or vertically
        // if we keep the tiles horizontally - we will have n-2 places to cover
        // if we keep our tiles vertically - we will have n-1 places to cover as vertically only 1 unit is covered by tiles
        //So, Total ways is the addition of both horizontal and vertical ways
        return (no_of_ways_tiles_can_be_kept(n - 1) + no_of_ways_tiles_can_be_kept(n - 2));
    }
}

//The same code is written in other way
// public class TilingProblem {
//     public static void main(String args[]) {
//         int n = 5;
//         System.out.println(tiles_count(n));
//     }

//     public static int tiles_count(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         // Horizontal
//         int hor_count = tiles_count(n - 2);

//         // Vertical;
//         int ver_count = tiles_count(n - 1);

//         return (hor_count + ver_count);
//     }
// }