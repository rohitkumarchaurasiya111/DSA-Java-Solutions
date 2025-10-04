package Queue;

public class circular_queue_array {
    static class CircularQueue {
        static int front;
        static int rear;
        static int size;
        static int arr[];

        public CircularQueue(int n) {
            arr = new int[n];
            front = rear = -1;
            size = n;
        }

        void add(int data) {
            if (front == -1 && rear == -1) {
                front++;
                rear++;
                arr[rear] = data;
                return;
            }
            if ((rear + 1) % size == front) {
                System.out.println("Overflow!");
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        int remove() {
            if (front == -1 && rear == -1) {
                System.out.println("Underflow!");
                return -1;
            } else if (front == rear) {
                int front_value = arr[front];
                front = rear = -1;
                return front_value;
            }
            int front_value = arr[front];
            front = (front + 1) % size;
            return front_value;
        }

        int peek() {
            if (front == -1 && rear == -1) {
                System.out.println("Underflow");
                return -1;
            }
            return arr[front];
        }

        boolean isEmpty() {
            if (front == -1 && rear == -1) {
                return true;
            }
            return false;
        }

        boolean isFull() {
            return ((rear + 1) % size == front);
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.add(0);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);

        System.out.println(cq.peek());
        cq.remove();
        cq.remove();
        System.out.println(cq.peek());
        cq.add(5);
        cq.add(6);
        cq.add(7);
        while (!cq.isEmpty()) {
            System.out.print(cq.remove() + " ");
        }
        cq.peek();
        cq.remove();
        cq.add(0);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        System.out.println(cq.isFull());
        while (!cq.isEmpty()) {
            System.out.print(cq.remove() + " ");
        }
    }
}
