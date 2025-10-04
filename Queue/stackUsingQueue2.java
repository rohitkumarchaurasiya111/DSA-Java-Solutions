package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue2 {

    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (!q2.isEmpty()) {
                q2.add(x);
                return;
            }
            q1.add(x);
        }

        public int pop() {
            int top = -1;
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    int val = q1.remove();
                    if (q1.isEmpty()) {
                        top = val;
                        break;
                    }
                    q2.add(val);
                }
            } else {
                while (!q2.isEmpty()) {
                    int val = q2.remove();
                    if (q2.isEmpty()) {
                        top = val;
                        break;
                    }
                    q1.add(val);
                }
            }
            return top;
        }

        public int top() {
            int top_val = -1;
            if (q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    int val = q1.remove();
                    if (q1.isEmpty()) {
                        top_val = val;
                    }
                    q2.add(val);
                }
            } else {
                while (!q2.isEmpty()) {
                    int val = q2.remove();
                    if (q2.isEmpty()) {
                        top_val = val;
                    }
                    q1.add(val);
                }
            }
            return top_val;
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(0);
        obj.push(1);
        obj.push(2);
        while (!obj.empty()) {
            System.out.println(obj.pop());

        }
    }
}
