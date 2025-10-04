package Stack;

import java.util.Stack;

public class valid_parenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("({}[])({})"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') { // Opening
                st.push(c);
            }
            // closing
            else if (st.isEmpty()) {
                return false;
            } else if ((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}')
                    || (st.peek() == '[' && c == ']')) {
                st.pop();
            } else {
                return false;
            }

        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
