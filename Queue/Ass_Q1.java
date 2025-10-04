package Queue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
// //Generate Binary Numbers

// Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
// Sample Input 1: N =2
// Sample Output 1:1 10

public class Ass_Q1 {
    public static void main(String[] args) {
        int num = 10;
        // for (int i = 1; i <= num; i++) {
        // generate_binary(i);
        // }
        generate_binary_optimize(num);
    }

    static void generate_binary_optimize(int num) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (num > 0) {
            String s1 = q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
            num--;
        }
    }

    static void generate_binary(int num) {
        Queue<Integer> q = new LinkedList<>();
        while (num > 0) {
            int digit = num % 2;
            num = num / 2;
            q.add(digit);
        }
        // Reverse this queue
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        while (!q.isEmpty()) {
            System.out.print(q.remove());
        }
        System.out.print("  ");
    }
}
