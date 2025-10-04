package String;

import java.util.ArrayList;
import java.util.Collections;

//Determine if 2 Strings areanagramsof each other
public class anagramsUsingArrayList {
    public static void main(String args[]) {
        String st1 = "CARE";
        String st2 = "race";
        System.out.println(check(st1, st2));
    }

    public static boolean check(String st1, String st2) {
        // Changing to Lower Case
        st1 = st1.toLowerCase();
        st2 = st2.toLowerCase();

        // Check the Length if it is equal or not
        if (st1.length() != st2.length()) {
            return false;
        }

        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();

        // Keep all the Characters one by one into the Array List
        for (int i = 0; i < st1.length(); i++) {
            Character ch1 = st1.charAt(i);
            list1.add(ch1);
            Character ch2 = st2.charAt(i);
            list2.add(ch2);
        }

        // Sorting the array list
        Collections.sort(list1);
        Collections.sort(list2);

        // Check if the sorted arrayList is same or not 
        if (list1.equals(list2)) {
            return true;
        }
        return false;
    }
}
