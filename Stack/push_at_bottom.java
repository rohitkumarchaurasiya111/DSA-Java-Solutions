package Stack;

import java.util.Stack;

public class push_at_bottom {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        push_bottom(s, 5);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
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
