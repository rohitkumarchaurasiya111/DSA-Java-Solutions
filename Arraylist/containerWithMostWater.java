package Arraylist;

import java.util.ArrayList;
//Container with Most Water
// For given n lines on x-axis, use 2 lines to form a container such
// that it holds maximum water.
// height = [1,8,6,2,5,4,8,3,7]

public class containerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.println("Max Water Capacity is: " + max_water(list));
        System.out.println("Max Water Capacity is: " + max_water_optimize(list));

    }

    // Brute Force Method - o(n^2)
    public static int max_water(ArrayList<Integer> height) {
        int max_water = 0;

        for (int i = 0; i < height.size(); i++) {
            int height_i = height.get(i);
            for (int j = i + 1; j < height.size(); j++) {
                int height_j = height.get(j);
                int min_height = Math.min(height_i, height_j);
                int area = min_height * (j - i);
                if (max_water < area) {
                    max_water = area;
                }
            }
        }
        return max_water;
    }

    // Two pointer Approach
    public static int max_water_optimize(ArrayList<Integer> height) {
        int i = 0;
        int j = height.size() - 1;
        int max_water = 0;
        while (i < j) {
            int min_height = Math.min(height.get(i), height.get(j));
            int width = j - i;
            int water = min_height * width;
            max_water = Math.max(max_water, water);
            if (height.get(i) < height.get(j)) {
                i++;
            } else {
                j--;
            }
        }
        return max_water;
    }
}
