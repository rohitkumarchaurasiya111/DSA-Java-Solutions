package Recursion;

// Write a program to findLength of aStringusing Recursion
public class LengthOfString {
    public static void main(String args[]) {
        String st = "Rohit is a Good Person";
        System.out.println(LengthStr(st));
    }

    static int LengthStr(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int len = LengthStr(str.substring(1)) + 1;
        return len;
    }
}
