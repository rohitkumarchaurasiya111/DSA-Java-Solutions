package Stack;

public class linkedList_Stack {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        public static Node head = null;

        boolean isEmpty() {
            // if (head == null) {
            // return true;
            // }
            // return false;
            return head == null;
        }

        void push(int data) {
            Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;
        }

        int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
