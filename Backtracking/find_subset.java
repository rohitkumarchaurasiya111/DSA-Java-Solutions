package Backtracking;

public class find_subset {
    public static void main(String args[]) {
        String given = "abc";
        findSubset(given, "", 0);
    }

    public static void findSubset(String given, String ans, int i) {
        // base
        if (i == given.length()) {
            System.out.print(ans + " ");
            return;
        }
        // kaam
        findSubset(given, ans + given.charAt(i), i + 1); // Yes

        findSubset(given, ans, i + 1); // NO

    }
}
