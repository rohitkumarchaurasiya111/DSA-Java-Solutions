package Arraylist;
//Beautiful ArrayList (MEDIUM)

import java.util.ArrayList;

// An Arraylist nums of size n is beautiful if:
// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2* nums.get(k) == nums.get(i) + nums.get(j).
// Given the integer n, return any beautiful arraylist nums of size n. There will be at least one valid answer for the given n.
// Sample Input 1: n = 4
// Sample Output 1: [2,1,4,3]
// Sample Input 2: n = 5
// Sample Output 2: [3,1,2,5,4]
// Constraints: 1 <= n <= 1000

public class Ass_Q4 {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> Result = construct_beautiful_array(n);
        System.out.println(Result);
    }

    public static ArrayList<Integer> construct_beautiful_array(int final_n) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int k = 2; k <= final_n; k++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                int odd_num = 2 * result.get(i) - 1;
                if (odd_num <= final_n) {
                    temp.add(odd_num);
                }
            }

            for (int i = 0; i < result.size(); i++) {
                int even_num = 2 * result.get(i);
                if (even_num <= final_n) {
                    temp.add(even_num);
                }
            }
            result = temp;
        }
        return result;
    }
}
