package Backtracking;

import java.util.ArrayList;
import java.util.List;

//Keypad Combinations
// Given a string containing digits from 2-9 inclusive, print all possible letter combinations that the number could represent. You can print the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class Keyboard_combinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String arr[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; // These are the strings
                                                                                             // mapped on specific keys
        if (digits.length() == 0) { // IF the input is null then the result will also be null
            return ans;
        }
        result(digits, 0, ans, arr, "");
        return ans;
    }

    public static void result(String digits, int i, List<String> ans, String arr[], String output) {
        if (i >= digits.length()) { // If the value of i = digits.length() that means all the digits are taken care
                                    // of
            ans.add(output);
            return;
        }
        int number = digits.charAt(i) - '0'; // It gives that exact number due to ascii value of num - ascii value of 0
        for (int j = 0; j < arr[number].length(); j++) { // This loop will gives all the permutation for all characters
                                                         // in strings.
            result(digits, i + 1, ans, arr, output + arr[number].charAt(j));
        }
    }
}
