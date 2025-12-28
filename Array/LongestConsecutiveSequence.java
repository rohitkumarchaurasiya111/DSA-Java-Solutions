package Array;

//Leetcode: 128, Longest Consecutive Sequence
import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int arr[] = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
        System.out.println(longestConsecutive(arr));

    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0; // if the array has 0 elements, return 0

        HashSet<Integer> hs = new HashSet<>(); // Using HashSet, to get only the unique elements
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int maxConsecutiveElements = 1;
        for (Integer temp : hs) {
            if (!hs.contains(temp - 1)) { // This might be the starting point as there are no consecutive number before
                                          // this
                int consecutiveNumbers = 1;
                int nextNumberNeeded = temp + 1;
                while (hs.contains(nextNumberNeeded)) { // For this temp, finding how many consecutive numbers are
                                                        // present
                    nextNumberNeeded++;
                    consecutiveNumbers++;
                }
                maxConsecutiveElements = Math.max(maxConsecutiveElements, consecutiveNumbers);
            }
        }
        return maxConsecutiveElements;
    }

}
