package Stack;

import java.util.Stack;

public class max_AreaInHistogram {
    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int small_right[] = nextSmaller_right(heights);
        int small_left[] = nextSmaller_left(heights);
        int area[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            area[i] = heights[i] * (small_right[i] - small_left[i] - 1);
        }
        int max_area = area[0];
        for (int i = 0; i < area.length; i++) {
            if (max_area < area[i]) {
                max_area = area[i];
            }
        }
        return max_area;
    }

    public static int[] nextSmaller_right(int height[]) {
        Stack<Integer> s = new Stack<>();
        int small_right[] = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                small_right[i] = s.peek();

            } else {
                small_right[i] = height.length;
            }
            s.push(i);
        }
        return small_right;
    }

    public static int[] nextSmaller_left(int height[]) {
        Stack<Integer> s = new Stack<>();
        int small_left[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                small_left[i] = s.peek();

            } else {
                small_left[i] = -1;
            }
            s.push(i);
        }
        return small_left;
    }
}
