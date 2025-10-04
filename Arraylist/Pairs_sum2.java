package Arraylist;

import java.util.ArrayList;

//Find if any pair in a Sorted & Rotated ArrayList has a target sum.
// list = [11, 15, 6, 8, 9, 10], target=16

public class Pairs_sum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        int pivot = find_pivot(list);
        System.out.println(pair_sum(list, target, pivot));
    }

    static boolean pair_sum(ArrayList<Integer> arr, int target, int pivot) {
        int i = pivot + 1;
        int j = pivot;
        int size = arr.size();
        while (i != j) {
            if (arr.get(i) + arr.get(j) == target) {
                System.out.println("Pairs are: " + arr.get(i) + " & " + arr.get(j));
                return true;
            } else if (arr.get(i) + arr.get(j) > target) {
                j = (j - 1 + size) % size;
            } else {
                i = (i + 1) % size;
            }
        }
        return false;
    }

    static int find_pivot(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return i;
            }
        }
        return 0;
    }
}
