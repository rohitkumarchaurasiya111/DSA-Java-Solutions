package Queue;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        public static Node head = null;
        public static Node tail = null;

        boolean isEmpty() {
            return (head == null && tail == null);
        }

        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = tail.next;
        }

        int remove() {
            if (head == null) {
                System.out.println("Underflow!");
                return -1;
            }
            int val = head.data;
            if (head == tail)
                head = tail = null;
            else
                head = head.next;
            return val;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Underflow");
                return -1;
            }
            return head.data;
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
        q.add(6);
        q.add(7);
        q.add(8);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.out.println(q.isEmpty());
    }
}
