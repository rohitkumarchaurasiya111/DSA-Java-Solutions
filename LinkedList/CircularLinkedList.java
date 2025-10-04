package LinkedList;

public class CircularLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add First
    void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            head.next = head;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        head = newNode;
        temp.next = head;
    }

    // Add between
    void add(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (temp.next != head && i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove First
    int removeFirst() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        } else if (head.next == head) {
            int val = head.data;
            size = 0;
            head = null;
            return val;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        int val = head.data;
        head = head.next;
        temp.next = head;
        size--;
        return val;
    }

    // Remove Between
    int removeBetween(int index) {
        if (index == 0) {
            int val = removeFirst();
            return val;
        }
        Node temp = head;
        int i = 0;
        while (temp.next.next != head && i < index - 1) {
            temp = temp.next;
            i++;
        }
        int val = temp.data;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    // Print Circular LinkedList
    void print() {
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addFirst(5);
        cll.addFirst(4);
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.addFirst(0);

        cll.print();

        cll.removeBetween(0);
        cll.print();
        System.out.println(size);
    }
}
