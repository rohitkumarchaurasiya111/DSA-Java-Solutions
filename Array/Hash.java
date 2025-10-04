package Array;

import java.util.HashSet;

public class Hash {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();
        int arr[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                check = 1;
            } else {
                set.add(arr[i]);
            }
        }
        if (check == 0) {
            System.out.println("False");
        } else {
            System.out.println(("True"));
        }
    }
}
