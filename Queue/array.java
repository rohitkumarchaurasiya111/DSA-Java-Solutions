package Queue;

public class array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            if ((rear == -1)) {
                return true;
            }
            return false;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Overflow!");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() {
            if (rear == -1) {
                System.out.println("Undrflow!");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if (rear == -1) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q.peek());
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}