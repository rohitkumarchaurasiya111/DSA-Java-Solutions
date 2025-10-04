package HashMap;

import java.util.HashMap;

public class Largest_SubArray_With_Sum0 {

    public static int subarraySum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_size = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int difference_in_size = i - map.get(sum);
                max_size = Math.max(max_size, difference_in_size);
            } else {
                map.put(sum, i);
            }
        }
        return max_size;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        System.out.println(subarraySum(arr));
    }
}
