package LinkedList;

public class DoublyLinkedList {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add
    void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Remove
    int removeFirst() {
        if (head == null) {
            System.out.println("LinkedList has no Elements to remove");
            return Integer.MIN_VALUE;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    int removeLast() {
        if (head == null) {
            System.out.println("LinkedList has no Elements to remove");
            return Integer.MIN_VALUE;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // Reverse Doubly Linked list
    void reverse() {
        Node prev = null;
        Node curr = head;
        Node above;

        while (curr != null) {
            above = curr.next;
            curr.next = prev;
            curr.prev = above;
            prev = curr;
            curr = above;
        }
        head = prev;
    }

    // Print doubly linked list
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(0);
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addLast(-1);
        dll.addLast(-2);

        dll.print();
        System.out.println(dll.removeLast());
        dll.print();
        System.out.println(size);
    }
}
