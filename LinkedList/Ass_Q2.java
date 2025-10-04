package LinkedList;

//Delete N Nodes After M Nodes of a Linked List
// We have a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list. Difficulty Level: Rookie.
// Sample Input 1: M=2 N=2 LL: 1->2->3->4->5->6->7->8
// Sample Output 1: 1->2->5->6

public class Ass_Q2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static void deleteNode(int M, int N) {
        Node prev_delete = head;
        while (prev_delete != null && prev_delete.next != null) {

            for (int i = 1; i < M; i++) {
                if (prev_delete == null) {
                    return;
                }
                prev_delete = prev_delete.next;
            }
            Node after_delete = prev_delete;
            for (int i = 1; i < N + 2; i++) {
                if (after_delete == null) {
                    return;
                }
                after_delete = after_delete.next;
            }
            prev_delete.next = after_delete;
            prev_delete = after_delete;
        }
    }

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

    public static void main(String[] args) {
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(8);

        print();
        deleteNode(2, 2);
        print();
    }
}
