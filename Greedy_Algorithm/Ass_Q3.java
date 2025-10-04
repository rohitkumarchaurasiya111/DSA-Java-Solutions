package Greedy_Algorithm;

import java.util.Arrays;

//Lexicographically smallest string of length N and sum K
// We have two integers N and K. The task is to print the lexicographically smallest string of length N consisting of lower-case English alphabets such that the sum of the characters of the string equals to K where 'a' = 1, 'b' = 2, 'c' = 3, ..... and 'z' = 26.
// Sample Input 1: N = 5, K = 42
// Sample Output 1: aaamz
// Sample Input 2 : N = 3, K = 25
// Sample Output 2: aaw

public class Ass_Q3 {
    public static void main(String[] args) {
        String ans = form_str(3, 25);
        System.out.println(ans);
    }

    static String form_str(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        k = k - n;

        for (int i = n - 1; i >= 0; i--) {
            if (k > 0) {
                k++;

                if (k >= 26) {
                    arr[i] = 'z';
                    k = k - 26;
                } else {
                    arr[i] = (char) ('a' + k - 1);
                    break;
                }
                // k = k + i;
            } else {
                break;
            }
        }
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }

        return ans;

    }
}
