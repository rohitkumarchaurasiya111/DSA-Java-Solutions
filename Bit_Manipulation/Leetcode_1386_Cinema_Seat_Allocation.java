package Bit_Manipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * LeetCode 1386 - Cinema Seat Allocation
 *
 * Given n rows with 10 seats each and some reserved seats,
 * find the maximum number of 4-person families that can be seated.
 *
 * A family must occupy one of:
 * [2,3,4,5], [4,5,6,7], or [6,7,8,9].
 * A row can fit at most 2 families.
 */

public class Leetcode_1386_Cinema_Seat_Allocation {
    //Using Bit Manipulation
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        /*
         * For every row, there are only 3 possible groups of 4 seats:
         *
         * LEFT   ->  seats 2,3,4,5
         * MIDDLE ->  seats 4,5,6,7
         * RIGHT  ->  seats 6,7,8,9
         *
         * A family can sit in LEFT or RIGHT simultaneously,
         * so a completely empty row can accommodate 2 families.
         *
         * We represent the availability of these 3 groups using 3 bits:
         *
         *      LEFT   MIDDLE   RIGHT
         *        1       1       1
         *
         * Binary 111 = 7
         *
         * Bit representation:
         *
         *     100 -> LEFT
         *     010 -> MIDDLE
         *     001 -> RIGHT
         *
         * So:
         *     111 = all 3 groups are possible
         *     110 = LEFT + MIDDLE possible
         *     101 = LEFT + RIGHT possible
         *     011 = MIDDLE + RIGHT possible
         *     etc.
         */

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            /*
             * First time we see a row:
             *
             * Assume all 3 possible groups are available.
             *
             *        LEFT MIDDLE RIGHT
             *          1     1      1
             *          ---------
             *             111 = 7
             */
            if (!hm.containsKey(row)) {
                hm.put(row, 7);
            }

            /*
             * Now check which group is affected by this reserved seat.
             *
             * We use AND (&) to turn OFF the corresponding bit.
             *
             * ---------------------------------------------------------
             *
             * Seat 2 or 3:
             *
             * LEFT group becomes impossible.
             *
             *       111
             *     & 011
             *       ---
             *       011 = 3
             *
             * ---------------------------------------------------------
             *
             * Seat 4 or 5:
             *
             * Both LEFT and MIDDLE groups become impossible.
             *
             *       111
             *     & 001
             *       ---
             *       001 = 1
             *
             * ---------------------------------------------------------
             *
             * Seat 6 or 7:
             *
             * Both MIDDLE and RIGHT groups become impossible.
             *
             *       111
             *     & 100
             *       ---
             *       100 = 4
             *
             * ---------------------------------------------------------
             *
             * Seat 8 or 9:
             *
             * RIGHT group becomes impossible.
             *
             *       111
             *     & 110
             *       ---
             *       110 = 6
             */

            if (col == 2 || col == 3) {
                // LEFT group is not possible
                hm.put(row, hm.get(row) & 3);

            } else if (col == 4 || col == 5) {
                // LEFT and MIDDLE groups are not possible
                hm.put(row, hm.get(row) & 1);

            } else if (col == 6 || col == 7) {
                // MIDDLE and RIGHT groups are not possible
                hm.put(row, hm.get(row) & 4);

            } else if (col == 8 || col == 9) {
                // RIGHT group is not possible
                hm.put(row, hm.get(row) & 6);
            }
        }


        /*
         * Rows which don't appear in the HashMap have NO reserved seats.
         *
         * Therefore, every such row can accommodate 2 families.
         *
         * Example:
         *
         * n = 5
         * HashMap contains rows {2, 4}
         *
         * Rows 1, 3, 5 are completely empty.
         *
         * Number of completely empty rows = 5 - 2 = 3
         *
         * Contribution = 3 * 2 = 6
         */

        int result = (n - hm.size()) * 2;


        /*
         * Now process rows that contain at least one reserved seat.
         *
         * The value stored in the HashMap tells us which groups
         * are still possible.
         *
         * Important cases:
         *
         * 111 (7) -> LEFT + RIGHT possible -> 2 families
         *
         * 101 (5) -> LEFT + RIGHT possible -> 2 families
         *
         * Any other non-zero value -> at most 1 family
         *
         * 000 (0) -> no family can sit
         */

        for (int availableGroups : hm.values()) {

            if (availableGroups == 7 || availableGroups == 5) {

                // LEFT + RIGHT are both available
                result += 2;

            } else if (availableGroups != 0) {

                // At least one valid group is available
                result += 1;
            }

            // If availableGroups == 0:
            // No group is available, so add nothing.
        }

        return result;
    }

    //Without uisng Bit-Manipulation - Just using HashMap
    public static int maxNumberOfFamilies2(int n, int[][] reservedSeats) {

        /*
         * We store reserved seats row-wise.
         *
         * Example:
         *
         * reservedSeats = {
         *     {1, 2},
         *     {1, 5},
         *     {2, 7}
         * }
         *
         * HashMap will look like:
         *
         * row 1 -> [2, 5]
         * row 2 -> [7]
         *
         * We only need to process rows that have reserved seats.
         */
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int column = seat[1];

            /*
             * If this row doesn't exist in the map,
             * create an empty HashSet for it.
             *
             * Then add the reserved seat to that row.
             */
            reserved
                .computeIfAbsent(row, k -> new HashSet<>())
                .add(column);
        }


        /*
         * In an empty row, we can always place 2 families:
         *
         * Family 1: seats 2,3,4,5
         * Family 2: seats 6,7,8,9
         *
         * So initially assume that EVERY row can accommodate
         * 2 families.
         *
         * Example:
         *
         * n = 5
         *
         * Initial answer = 5 * 2 = 10
         */
        int answer = 2 * n;


        /*
         * Now process only the rows that have reserved seats.
         *
         * Rows that are NOT in the HashMap are completely empty,
         * so they can definitely accommodate 2 families.
         */
        for (Map.Entry<Integer, Set<Integer>> entry : reserved.entrySet()) {

            // Get all reserved seats for this particular row.
            Set<Integer> seats = entry.getValue();


            /*
             * There are 3 possible groups of 4 seats:
             *
             * LEFT:
             *      2 3 4 5
             *
             * MIDDLE:
             *      4 5 6 7
             *
             * RIGHT:
             *      6 7 8 9
             *
             * We check whether each group is completely free.
             */


            // Can a family sit in seats 2,3,4,5?
            boolean left =
                    !seats.contains(2) &&
                    !seats.contains(3) &&
                    !seats.contains(4) &&
                    !seats.contains(5);


            // Can a family sit in seats 4,5,6,7?
            boolean middle =
                    !seats.contains(4) &&
                    !seats.contains(5) &&
                    !seats.contains(6) &&
                    !seats.contains(7);


            // Can a family sit in seats 6,7,8,9?
            boolean right =
                    !seats.contains(6) &&
                    !seats.contains(7) &&
                    !seats.contains(8) &&
                    !seats.contains(9);


            /*
             * We initially counted 2 families for this row.
             *
             * Case 1:
             *
             * LEFT and RIGHT are both available.
             *
             *       2 3 4 5 | 6 7 8 9
             *       Family1 | Family2
             *
             * So the row can actually accommodate 2 families.
             *
             * No change to answer.
             */
            if (left && right) {
                // 2 families can still sit.
                // We already counted them, so do nothing.
            }


            /*
             * Case 2:
             *
             * At least one of LEFT, MIDDLE, RIGHT is available.
             *
             * Therefore, we can fit exactly 1 family.
             *
             * But we initially assumed 2 families.
             *
             * So we remove 1 from the answer.
             */
            else if (left || middle || right) {
                answer--;
            }


            /*
             * Case 3:
             *
             * None of the three groups is available.
             *
             * Therefore, no family can sit in this row.
             *
             * We initially counted 2 families,
             * so we need to remove both.
             */
            else {
                answer -= 2;
            }
        }


        /*
         * Return the maximum number of families
         * that can be accommodated.
         */
        return answer;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] reservedSeats = {
            {1, 2},
            {1, 3},
            {1, 8},
            {2, 6}
        };

        int result = maxNumberOfFamilies(n, reservedSeats);

        System.out.println("Maximum number of families: " + result);
    }
}

