package Stack;
//Palindrome Linked List

// We have a singly linked list of characters, write a function that returns true if the given list is a
// palindrome, else false.

import java.util.Stack;

public class Ass_Q1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode head;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        // head.next.next.next = new ListNode(1);
        System.out.println(check_palindrome(head));
    }

    static boolean check_palindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != s.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;

    }

}
