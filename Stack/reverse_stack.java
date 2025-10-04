package Stack;

import java.util.Stack;

public class reverse_stack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reverse(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        push_bottom(s, top);

    }

    static void push_bottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        push_bottom(s, data);
        s.push(top);
    }
}
