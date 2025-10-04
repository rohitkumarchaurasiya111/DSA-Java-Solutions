package Backtracking;
//Author:- Rohit Kumar Chaurasiya

//Time :- 2024/07/20 8:00pm

//Find all permutation of a string
//It is enumeration backtracking
//If n elements then Permutation = n!
//For permutation, At first we have n choices then n-1 choices as one is already choosed then n-2 choices. So, in total we have n! choices.

public class permutationOFstring {
    public static void main(String[] args) {
        String str = "abc";
        permutation_string(str, "");
    }

    /* Here,We create a loop which run upto str.length() so that each letter in str can be kept on ans. If char(i) is choosen then it is removed from original string so we will have n-1 choices to choose and so on. we set the base case as if str.length==0 then print ans and return  */
    public static void permutation_string(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char chossed_char = str.charAt(i);
            // ans += chossed_char;
            String Str_without_choosed_char = str.substring(0, i) + str.substring(i + 1);
            permutation_string(Str_without_choosed_char, ans + chossed_char);
        }

    }
}
