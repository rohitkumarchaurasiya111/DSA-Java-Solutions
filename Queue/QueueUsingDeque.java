package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> dq;

        public Queue() {
            dq = new LinkedList<>();
        }

        void add(int data){
            dq.addLast(data);
        }

        int remove(){
            return dq.removeFirst();
        }

        int peek(){
            return dq.getFirst();
        }

        boolean isEmpty(){
            return dq.isEmpty();
        }

    }  

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
