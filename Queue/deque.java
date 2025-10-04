package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
// import java.util.LinkedList;

public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addFirst(0);

        System.out.println(dq);
        dq.removeFirst();
        dq.remove();
        dq.removeLast();
        System.out.println(dq);
        System.out.println(dq.peekFirst());
    }
}
