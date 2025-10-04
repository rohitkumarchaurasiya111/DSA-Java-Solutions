package Greedy_Algorithm;

// //Maximum Balanced String Partitions
// We have balanced string str of size N with an equal number of L and R, the task is to find a
// maximum number X, such that a given string can be partitioned into X balanced substring. A
// string is called to be balanced if the number of 'L's in the string equals the number of 'R's.
// Input: "LRRRRLLRLLRL"
// Output: 3

public class Ass_Q1 {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(max_balanced_string(str));
    }

    static int max_balanced_string(String str) {
        int no_of_beautiful = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                l++;
            } else if (str.charAt(i) == 'R') {
                r++;
            }
            if (l == r) {
                no_of_beautiful++;
                l = 0;
                r = 0;
            }
        }
        return no_of_beautiful;
    }
}
