package Stack;

import java.util.Stack;

public class Ass_Q3 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> string_stack = new Stack<>();
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch.equals('[')) {
                num_stack.push(num);
                num = 0;
                string_stack.push(ch.toString());
            } else if (ch.equals(']')) {
                StringBuilder sb = new StringBuilder("");
                while (!string_stack.isEmpty() && !string_stack.peek().equals("[")) {
                    sb = sb.insert(0, string_stack.pop());
                }
                string_stack.pop(); // To pop [ from stack;

                String to_multiply = sb.toString();
                for (int j = 0; j < num_stack.peek() - 1; j++) {
                    sb = sb.append(to_multiply);
                }
                num_stack.pop();
                string_stack.push(sb.toString());
            } else {
                string_stack.push(ch.toString());
            }
            i++;
        }
        StringBuilder result = new StringBuilder("");
        while (!string_stack.isEmpty()) {
            result = result.insert(0, string_stack.pop());
        }
        return result.toString();
    }
}
