package Array;

import java.util.*;

public class menu {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String menu[] = new String[5];
        for (int i = 0; i < menu.length; i++) {
            System.out.print("Enter Item " + (i + 1) + " : ");
            menu[i] = scan.nextLine();
        }
        System.out.println("Enter item to search for: ");
        String key = scan.nextLine();
        int index = find(menu, key);
        if (index == -1) {
            System.out.println("Key Not Present!");
        } else {
            System.out.println("Key is at Index " + index);
        }
        scan.close();

    }

    public static int find(String arr[], String key) {
        for (int i = 0; i < arr.length; i++) {
            if (key.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}