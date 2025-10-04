package Arraylist;
//Most Frequent Number following Key (EASY)

// You are given an integer Arraylist nums. You are also given an integer key, which is present in nums.
// For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. In other words, count the number of indices i such that:
// 0 <= i <= nums.size() - 2,
// nums.get(i) == key and,
// nums.get(i+1) == target.
// Return the target with the maximum count.
// (Assumption - that the target with maximum count is unique.)
// Sample Input 1 :nums = [1,100,200,1,100], key = 1
// Sample Output 1: 100
// Explanation:
// For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key. No other integers follow an occurrence of key, so we return 100.

public class Ass_Q3 {
    public static void main(String[] args) {
        int nums[] = { 1, 100, 200, 1, 100 };
        int key = 1;
        System.out.println(mostFrequent(nums, key));
    }

    public static int mostFrequent(int[] nums, int key) {
        int result[] = new int[1000];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                result[nums[i + 1] - 1]++;
            }
        }

        int most_frequent_num = 0;
        int max_count = 0;
        for (int i = 0; i < result.length; i++) {
            if (max_count < result[i]) {
                most_frequent_num = i + 1;
                max_count = result[i];
            }
        }
        return most_frequent_num;
    }
}
