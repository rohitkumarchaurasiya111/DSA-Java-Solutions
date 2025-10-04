package Stack;
//Trapping Rain Water

// We have an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

import java.util.Stack;


public class Ass_Q4 {
    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int max_right[] = right_tall(height);
        int max_left[] = left_tall(height);
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            int small_height = Math.min(max_right[i], max_left[i]);
            if (small_height == -1) {
                continue;
            }
            area += small_height - height[i];
        }
        return area;
    }

    public static int[] right_tall(int[] height) {
        Stack<Integer> height_right = new Stack<>();
        int max_right[] = new int[height.length];
        int max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            while (!height_right.isEmpty() && height_right.peek() <= height[i]) {
                height_right.pop();
            }
            if (height_right.isEmpty()) {
                max_right[i] = -1;
            } else {
                max = Math.max(height_right.peek(), max);
                max_right[i] = max;
            }

            height_right.push(height[i]);
        }
        return max_right;
    }

    public static int[] left_tall(int[] height) {
        Stack<Integer> height_left = new Stack<>();
        int max = 0;
        int max_left[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!height_left.isEmpty() && height_left.peek() <= height[i]) {
                height_left.pop();
            }
            if (height_left.isEmpty()) {
                max_left[i] = -1;
            } else {
                max = Math.max(max, height_left.peek());
                max_left[i] = max;
            }

            height_left.push(height[i]);
        }
        return max_left;
    }
}
