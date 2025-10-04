package Stack;

import java.util.Stack;

public class next_greater {
    public static void main(String[] args) {
        int nums[] = { 6, 8, 0, 1, 3 };
        int ans[] = nextGreaterElements(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr_val = nums[i];
            int next_greater = -1;
            while (!s.isEmpty() && s.peek() <= curr_val) {
                s.pop();
            }
            if (s.isEmpty()) {
                next_greater = -1;
            } else {
                next_greater = s.peek();
            }
            ans[i] = next_greater;
            s.push(nums[i]);
        }
        return ans;
    }
}
