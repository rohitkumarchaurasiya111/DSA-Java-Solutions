package Queue;

import java.util.ArrayDeque;
// import java.util.LinkedList;
import java.util.Queue;

public class JavaCollectionFramework {
    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
