package Array;

//Leetcode 229. Majority Element II
//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

import java.util.*;

class MajorityElement2 {

    public static void main(String[] args) {
        int num[] = { 3, 3, 2, 3 };
        System.out.println(majorityElement(num));
    }

    // Using HashMap
    public static List<Integer> majorityElementII(int[] nums) {
        // HashMap will store the <Value,Frequency>
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Keeps the elements of the Array into the HashMap
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        // Check among the HashMap elements whose frequncy matches the criteria of
        // Majority Element
        int minNoOfTimes = nums.length / 3;
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > minNoOfTimes)
                ans.add(key);
        }
        return ans;
    }

    // Using Boyer Moore Voting Element
    // An array can contain Maximum 2 majorityElement as according to our Condition
    public static List<Integer> majorityElement(int[] nums) {
        int ele1 = -1;
        int ele2 = -1;
        int count1 = 0;
        int count2 = 0;

        // This loop will vote for the elements which might be our majority Element
        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i]) { // IF current element is our choosen one then it's count (vote) increases
                count1++;
            } else if (ele2 == nums[i]) { // IF current element is our choosen one then it's count (vote) increases
                count2++;
            } else if (count1 == 0) { // If count(vote) of choosen element is 0
                ele1 = nums[i]; // Then current element also have equal chances to win
                count1++; // So,choose the current element and increase it's count by 1
            } else if (count2 == 0) {
                ele2 = nums[i];
                count2++;
            } else { // If current element is neither of my choosen element then decrease the vote
                count1--;
                count2--;
            }
        }

        // To check if the choosen elements are actually the required majority Element
        // or not
        int minNoOfTimes = nums.length / 3;
        count1 = 0;
        count2 = 0;

        // Counting the no. of times our choosen element comes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2)
                count2++;
        }
        List<Integer> result = new ArrayList<Integer>();

        // If our choosen elements satisies the condition of Majority Element then add
        // them to results
        if (count1 > minNoOfTimes)
            result.add(ele1);
        if (count2 > minNoOfTimes && ele1 != ele2)
            result.add(ele2);

        return result;
    }

}
