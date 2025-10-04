package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> dq;

        public Stack() {
            dq = new LinkedList<>();
        }

        void push(int data) {
            dq.addLast(data);
        }

        int pop() {
            return dq.removeLast();
        }

        int peek() {
            return dq.getLast();
        }

        boolean isEmpty() {
            return dq.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(0);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        while (!obj.isEmpty()) {
            System.out.println(obj.pop());
        }
    }
}
