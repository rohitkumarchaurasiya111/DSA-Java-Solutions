package Queue;

import java.util.Stack;

public class QueusUsingTwoStack {
    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if (s1.isEmpty()) {
                s1.push(x);
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            if (s1.isEmpty()) {
                System.out.println("Underflow");
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if (s1.isEmpty()) {
                System.out.println("Underflow");
                return -1;
            }
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        
        while (!q.empty()) {
            System.out.println(q.pop());
        }
    }

}
