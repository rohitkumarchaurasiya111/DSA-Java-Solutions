package Heaps;

import java.util.PriorityQueue;

// Weakest Soldier

// We are given an mxn binary matrix of 1's (soldiers) and 0's (civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the O's in each row.
// A row i is weaker than a row j if one of the following is true:
// • The number of soldiers in row i is less than the number of soldiers in row j.
// • Both rows have the same number of soldiers and i < j.
// Find the K weakest rows.
// m=4, n=4, k=2
// ans = row0 & row2
// 1000
// 1111
// 1000
// 1000

public class Weakest_Soldier {

    static class details implements Comparable<details> {
        int soldiers;
        int index;

        public details(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        public int compareTo(details d2) {
            if (this.soldiers == d2.soldiers) {
                return this.index - d2.index;
            } else {
                return this.soldiers - d2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2;

        PriorityQueue<details> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int soldier = 0;
            int index = i;
            for (int j = 0; j < army[i].length; j++) {
                if (army[i][j] == 1) {
                    soldier++;
                } else {
                    break;
                }
            }
            pq.add(new details(soldier, index));
        }

        for (int i = 0; i < k; i++) {
            int ind = pq.remove().index;
            System.out.println("R" + ind);
        }

    }
}