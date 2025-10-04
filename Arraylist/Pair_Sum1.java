package Arraylist;

import java.util.ArrayList;

//Find if any pair in a Sorted ArrayList has a target sum.
// list = [1, 2, 3, 4, 5, 6], target=5
public class Pair_Sum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 8;
        System.out.println(find_pair_sum(list, target));
        System.out.println(find_pair_sum_optimized(list, target));
    }

    // brute force method
    static boolean find_pair_sum(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == target) {
                    System.out.println("Pairs are: " + arr.get(i) + " & " + arr.get(j));
                    return true;

                }
            }
        }
        return false;
    }

    // Optimized Method - Two pointer Approach 
    static boolean find_pair_sum_optimized(ArrayList<Integer> arr, int target) {
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if (arr.get(i) + arr.get(j) == target) {
                System.out.println("Pairs are: " + arr.get(i) + " & " + arr.get(j));
                return true;
            } else if (arr.get(i) + arr.get(j) > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
