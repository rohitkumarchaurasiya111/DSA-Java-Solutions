package Array;

//Leetcode 169. Majority Element
//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

class MajorityElement {

    public static void main(String[] args) {
        int num[] = { 3, 3, 2, 3 };
        System.out.println(majorityElement(num));
    }

    // The element which occurs more than n/2 times is considered as a majority
    // Element, An array can contain only 1 majority Element
    public static int majorityElement(int[] nums) {
        // Using Boyre-Moore Voting Algorithm
        int element = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) { // If current element is our choosen element then increase the count
                count++;
            } else { // If current element is not the choosen element
                if (count == 0) {
                    element = nums[i]; // If count is 0 then current Element has equal chances to become our majority
                                       // Element
                    count++;
                } else
                    count--; // If current element is not our choosen element then it's probability to become
                             // major Element will decrease
            }
        }
        return element;
    }
}
