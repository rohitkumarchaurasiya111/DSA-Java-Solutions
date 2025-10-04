package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Underflow!");
                return -1;
            }
            return q1.remove();
        }

        public int top() {
            if (q1.isEmpty()) {
                System.out.println("Underflow!");
                return -1;
            }
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
}
