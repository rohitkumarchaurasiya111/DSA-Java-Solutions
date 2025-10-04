package String;

import java.util.Arrays;

public class anagram {
    public static void main(String args[]) {
        String st1 = "CARE";
        String st2 = "race";
        System.out.println(compare(st1, st2));
    }

    public static boolean compare(String st1, String st2) {
        // Convertin to lower case
        st1 = st1.toLowerCase();
        st2 = st2.toLowerCase();

        // CHecking if both lengths are same or not
        if (st1.length() != st2.length()) {
            return false;
        }

        // Converting the String to character Array
        char array1[] = st1.toCharArray();
        char array2[] = st2.toCharArray();

        // Sorting these character arrays
        Arrays.sort(array1);
        Arrays.sort(array2);


        // compare if the arrays are same or not
        if (Arrays.equals(array1, array2)) {
            return true;
        }
        return false;

    }
}
