package Arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Lonely Numbers in ArrayList (MEDIUM)
// You are given an integer arraylist nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
// Return all lonely numbers in nums. You may return the answer in any order.
// Sample Input 1: nums = [10,6,5,8]
// Sample Output 1: [10,8]
// Explanation:
// - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums. - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
// - 5 is not a lonely number since 6 appears in nums and vice versa. Hence, the lonely numbers in nums are [10, 8]. Note that [8, 10] may also be returned.

public class Ass_Q2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);

        List<Integer> Lonely_list = new ArrayList<>();
        Lonely_list = findLonely(list);
        System.out.println(Lonely_list);
    }

    public static List<Integer> findLonely(ArrayList<Integer> nums) {
        Collections.sort(nums); //Sorts all the numbers in ascending order for easy to findlonely
        System.out.println(nums);
        List<Integer> lonely_list = new ArrayList<>();
        for (int i = 1; i < nums.size() - 1; i++) {  //It is for all the between elements where we check if the element before and after is it's adjacent or not
            if (nums.get(i) != nums.get(i - 1) && nums.get(i) != nums.get(i + 1) && nums.get(i) - 1 != nums.get(i - 1)
                    && nums.get(i) + 1 != nums.get(i + 1)) {
                lonely_list.add(nums.get(i));
            }
        }

        if (nums.size() == 1) {  //If nums has only one element then it will be lonely
            lonely_list.add(nums.get(0));
        }

        if (nums.size() > 1) {  //It is for checking first and last element which is ignored in first loop
            if (nums.get(0) + 1 < nums.get(1)) {
                lonely_list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 1) - 1 > nums.get(nums.size() - 2)) {
                lonely_list.add(nums.get(nums.size() - 1));
            }
        }
        return lonely_list;
    }
}
