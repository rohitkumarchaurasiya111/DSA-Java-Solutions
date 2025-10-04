package Arraylist;

import java.util.ArrayList;

//Monotonic ArrayList (EASY)
// An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
// An Arraylist nums is monotone increasing if for all i <= j, nums.get(i) <= nums.get(j). An Arraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).
// Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
public class Ass_Q1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        if (check_monotone(list)) {
            System.out.println("The array is Monotone");
        } else {
            System.out.println("The array is not monotone");
        }
    }

    static boolean check_monotone(ArrayList<Integer> list) {
        boolean ascending = true;
        boolean decreasing = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                ascending = false;
            }
            if (list.get(i) < list.get(i + 1)) {
                decreasing = false;
            }
        }

        boolean result = ascending || decreasing; // The result will only be false only if the array is neither
                                                  // increasing neither decreasing
        return result;

    }
}
