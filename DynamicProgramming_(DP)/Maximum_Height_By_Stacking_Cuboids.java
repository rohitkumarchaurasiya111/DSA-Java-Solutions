//Leetcode 1691: Maximum Height by Stacking Cuboids (Hard)
// Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.
// You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.
// Return the maximum height of the stacked cuboids.

// Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
// Output: 190

// Input: cuboids = [[38,25,45],[76,35,3]]
// Output: 76

// Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
// Output: 102

import java.util.Arrays;

public class Maximum_Height_By_Stacking_Cuboids {
    public static void main(String[] args) {
        // int cuboids[][] = {{50,45,20},{95,37,53},{45,23,12}}; //Output - 190
        // int cuboids[][] = {{38,25,45},{76,35,3}}; //Output - 76
        // int cuboids[][] = {{35,32,11},{7,6,65},{3,39,41}}; //Output - 65
        int cuboids[][] = { { 92, 47, 83 }, { 75, 20, 87 }, { 68, 12, 83 }, { 12, 85, 15 }, { 16, 24, 47 },
                { 69, 65, 35 }, { 96, 56, 93 }, { 89, 93, 11 }, { 86, 20, 41 }, { 69, 77, 12 }, { 83, 80, 97 },
                { 90, 22, 36 } }; // Output - 447
        System.out.println("Maximum height by Stacking Cuboid is: " + maxHeight(cuboids));
    }

    // Using LIS (Longest Increasing Subsequence) Concept
    public static int maxHeight(int[][] cuboids) {
        // Sort the rows such that the maximum Values are the height i.e. the last
        // column
        for (int row[] : cuboids) {
            Arrays.sort(row);
        }

        // Example:
        // 20 45 50
        // 37 53 95
        // 12 23 45

        // Sort the columns so that cuboids are arranged in the smallest to biggest
        // manner (top - smallest and bottom - largest)
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        }); // If first value is same keep the cuboid whose second value is less as we need
            // the smaller cuboid first then the larger cuboid, if we don't do this and only
            // sort on the basis of one column then we might get wrong answer on cases where
            // 1st value is same.
        // Eg: A = {10, 20, 30} and B = {10, 50, 60} and If the array looks like this:
        // B, A then maxHeight we get is 60 but correct answer is 90

        // Example:
        // 12 23 45
        // 20 45 50
        // 37 53 95

        // Now, Perform the LIS based on the conditions of stacking cuboids
        int dpHeight[] = new int[cuboids.length];

        // Initializing the values as initially the minimum each cuboids can give is
        // their own height
        for (int i = 0; i < cuboids.length; i++) {
            dpHeight[i] = cuboids[i][2];
        }

        int maxHeight = 0; // To keep track of the maximum height

        for (int i = 0; i < cuboids.length; i++) { // To iterate over all the cuboids
            for (int j = 0; j < i; j++) { // To find all the possible combinations of cuboids which gives the maxHeight
                if ((cuboids[i][0] >= cuboids[j][0]) && (cuboids[i][1] >= cuboids[j][1])
                        && (cuboids[i][2] >= cuboids[j][2])) { // valid condition where cuboids can be stacked
                    dpHeight[i] = Math.max(dpHeight[j] + cuboids[i][2], dpHeight[i]);
                }
            }
            maxHeight = Math.max(maxHeight, dpHeight[i]);
        }
        return maxHeight;
    }
}
