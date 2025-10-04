package LinkedList;

//Swapping Nodes in a Linked List
// We have a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields. It may be assumed that all keys in the linked list are distinct.
// Sample Input 1: 1->2->3->4, x = 2, y = 4
// Sample Output 1: 1->4->3->2

public class Ass_Q3 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    static void print() {
        if (head == null) {
            System.out.println("Linkedlist is Empty!");
        }
        Node temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    static void swap(int key1, int key2) {
        if (key1 == key2) {
            return;
        }

        Node swap1_prev = null;
        Node swap1 = head;
        Node swap2_prev = null;
        Node swap2 = head;

        while (swap1 != null && swap1.data != key1) {
            swap1_prev = swap1;
            swap1 = swap1.next;
        }

        while (swap2 != null && swap2.data != key2) {
            swap2_prev = swap2;
            swap2 = swap2.next;
        }

        if (swap1_prev == null) {
            // Key-1 is in head
            head = swap2;
        } else {
            swap1_prev.next = swap2;
        }

        if (swap2_prev == null) {
            // key-2 is in head
            head = swap1;
        } else {
            swap2_prev.next = swap1;
        }
        Node temp1 = swap1.next;
        swap1.next = swap2.next;
        swap2.next = temp1;
    }

    public static void main(String[] args) {
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        print();
        swap(0, 1);
        print();
    }
}
