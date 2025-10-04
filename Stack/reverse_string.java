package Stack;

import java.util.Stack;

public class reverse_string {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String name = "Rohit Chaurasiya";
        for (int i = 0; i < name.length(); i++) {
            s.push(name.charAt(i));
        }
        StringBuilder reverse_name = new StringBuilder("");
        while (!s.isEmpty()) {
            reverse_name.append(s.pop());
        }
        System.out.println(reverse_name);
    }
}
