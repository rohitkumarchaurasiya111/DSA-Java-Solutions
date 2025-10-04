package Arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(-99);
        list.add(55);
        list.add(69);
        System.out.println("Before Swap: " + list);

        // Swapping
        swap_arraylist(list, 1, 2);
        System.out.println("After Swap: " + list);

        // Find maximum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("Maximum Value: " + max);

        // Sorting an Array
        Collections.sort(list); // It will sort in ascending order
        System.out.println("Ascending: " + list);

        Collections.sort(list, Collections.reverseOrder()); // Descending Order
        System.out.println("Descending: " + list);
    }

    static void swap_arraylist(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

}
