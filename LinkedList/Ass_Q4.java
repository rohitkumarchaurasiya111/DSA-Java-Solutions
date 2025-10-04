package LinkedList;

//Odd Even Linked List
// We have a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
// Sample Input 1: 8->12->10->5->4->1->6->NULL
// Sample Output 1: 8->12->10->4->6->5->1->NULL

public class Ass_Q4 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node head;

    public static Node oddEvenList(Node head) {
        Node temp = head;
        Node odd_head = new Node(-1);
        Node even_head = new Node(0);
        Node odd = odd_head;
        Node even = even_head;
        while (temp != null) {
            if (temp.val % 2 == 0) { // Even val
                even.next = temp;
                even = even.next;
            } else { // Odd val
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        even.next = null;
        odd.next = null;

        Node result = odd_head.next;
        
        temp = result;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = even_head.next;

        return result;
    }

    static void print(Node head) {
        if (head == null) {
            System.out.println("Linkedlist is Empty!");
        }
        Node temp = head;
        System.out.print("LinkedList: ");
        while (temp != null) {
            System.out.print(temp.val + "-> ");
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
        print(head);

        head = oddEvenList(head);
        print(head);
    }
}
