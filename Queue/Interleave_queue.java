package Queue;

import java.util.LinkedList;
import java.util.Queue;
//Interleave 2 Halves of a Queue (even length)

public class Interleave_queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave_queue(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

    static void interleave_queue(Queue<Integer> q) {
        int size = q.size();
        Queue<Integer> first = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }

        for (int i = 0; i < size / 2; i++) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }
}
