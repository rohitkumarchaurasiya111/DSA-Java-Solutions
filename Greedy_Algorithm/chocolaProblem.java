package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

//We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2, xm-1 and along horizontal lines with y1, y2, ..., yn-1.
// Compute the minimal cost of breaking the whole chocolate into single squares.

public class chocolaProblem {
    public static void main(String[] args) {
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costhor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Comparator.reverseOrder());
        Arrays.sort(costhor, Comparator.reverseOrder());

        System.out.println(min_cost(costVer, costhor));
    }

    static int min_cost(Integer costVer[], Integer costhor[]) {
        int vertical_piece = 1;
        int horizontal_piece = 1;
        int cost = 0;

        int i = 0, j = 0;
        while (i < costVer.length && j < costhor.length) {
            if (costVer[i] > costhor[j]) {
                cost += costVer[i] * vertical_piece;
                horizontal_piece++;
                i++;
            } else {
                cost += costhor[j] * horizontal_piece;
                vertical_piece++;
                j++;
            }
        }
        while (i < costVer.length) {
            cost += costVer[i] * vertical_piece;
            horizontal_piece++;
            i++;
        }
        while (j < costhor.length) {
            cost += costhor[j] * horizontal_piece;
            vertical_piece++;
            j++;
        }
        return cost;
    }
}
