package HashMap;

import java.util.HashMap;

public class SubArray_Sum_Equal_to_k {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0, 1); // For the case when sum==k
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int check = sum - k;
            if (map.containsKey(check)) {
                count += map.get(check);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1 };
        System.out.println(subarraySum(arr, 2));
    }
}
