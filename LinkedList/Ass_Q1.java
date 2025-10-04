package LinkedList;

// Intersection of Two Linked Lists
// In a system there are two singly linked list. By some programming error, the end node of one of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a program to get the point where two linked lists merge.

public class Ass_Q1 {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode head1;
    public static ListNode head2;

    public static void main(String[] args) {
        head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        head2 = new ListNode(0);
        head2.next = head1.next;

        ListNode intersection = getIntersectionNode(head2, head1);
        if (intersection == null) {
            System.out.println("No Intersection");
        } else {
            System.out.println("Intersection exist");
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }
}
