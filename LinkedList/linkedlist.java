package LinkedList;

public class linkedlist {
    public static class Node {
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

    void add_first(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void add_last(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    void add(int index, int data) {
        if (index == 0) {
            add_first(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    int remove_first() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    int remove_last() {
        if (size == 0) {
            System.out.println("LinkedList is Empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = tail.data;
            head = tail = null;
            size = 0;
            return value;
        }
        Node temp = head;
        int i = 0;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int value = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return value;
    }

    int iterativ_search(int key) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    int helper_recursive_search(Node temp, int key) {
        if (temp == null) {
            return -1;
        } else if (temp.data == key) {
            return 0;
        }
        int index = helper_recursive_search(temp.next, key);
        if (index == -1) {
            return -1;
        }
        return (index + 1);
    }

    int recursive_search(int key) {
        return helper_recursive_search(head, key);
    }

    void reverse() { // O(N)
        Node prev = null;
        Node curr = tail = head;
        Node above = null;

        while (curr != null) {
            above = curr.next;
            curr.next = prev;
            prev = curr;
            curr = above;
        }
        head = prev;
    }

    void delete_nth_from_end(int n) {
        // Calculate size of linkedlist
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // the positon of node to delete from first
        int idx = sz - n + 1; // Index to delete

        if (idx == 1) { // If we have to delete the head
            head = head.next;
            return;
        }

        temp = head;
        for (int i = 0; i < idx - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return;
    }

    Node find_mid_node(Node head) { // Helper for check_palindrome
        // We will use slow and fast method to find mid node
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    boolean check_palindrome() {
        if (head == null || head.next == null) { // If no element or only one element is present then it is palindrome
                                                 // already
            return true;
        }

        // 1. Find mid
        Node mid = find_mid_node(head);
        // 2. Reverse half
        Node prev = null;
        Node curr = mid;
        Node above;
        while (curr != null) {
            above = curr.next;
            curr.next = prev;
            prev = curr;
            curr = above;
        }
        Node head_right = prev;
        // 3. Check

        Node temp = head;
        Node temp_right = head_right;
        while (temp_right != null) {
            if (temp.data != temp_right.data) {
                return false;
            }
            temp = temp.next;
            temp_right = temp_right.next;
        }

        return true;
    }

    static boolean detect_cycle() {
        // Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // First find cycle exists or not. If exist, then start = head and move start +
    // 1, fast + 1 until start == fast, if start == fast then fast->prev is the last
    // node. So, to find fast->prev we always keep track of prev_fast.

    static void remove_cycle() {

        // Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        Node prev_fast = null;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            prev_fast = fast.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true; // If cycle is present
                break;
            }
        }

        if (cycle == false) { // Cycle is not present
            return;
        }

        // If cycle is present
        slow = head;

        while (slow != fast) {
            prev_fast = fast; // to find last node
            slow = slow.next;
            fast = fast.next;
        }
        prev_fast.next = null; // Last node points to null

    }

    Node merge_sort(Node head) {
        // Base
        if (head == null || head.next == null) {
            return head;
        }

        // Mid
        Node mid = find_mid(head);
        Node right_head = mid.next;
        mid.next = null;

        // Recursive call
        Node newLeft = merge_sort(head);
        Node newRight = merge_sort(right_head);

        // Sort
        return sorting(newLeft, newRight);
    }

    static Node sorting(Node head, Node right_head) {
        Node result = new Node(-1);
        Node temp = result;
        while (head != null && right_head != null) {
            if (head.data <= right_head.data) {
                temp.next = head;
                head = head.next;
            } else {
                temp.next = right_head;
                right_head = right_head.next;
            }
            temp = temp.next;
        }

        while (head != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
        }

        while (right_head != null) {
            temp.next = right_head;
            right_head = right_head.next;
            temp = temp.next;
        }
        // temp.next = null;

        // if (head != null) {
        // temp.next = head;
        // } else {
        // temp.next = right_head;
        // }

        return result.next;
    }

    static Node find_mid(Node head) { // Helper function for merge_sort
        // We use slow and fast pointer to find mid
        Node slow = head;
        Node fast = head.next; // So that, In 6 nodes, 3 will be the mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void zik_zak(Node head) {
        // Find mid
        Node mid = find_mid(head);

        // Reverse half of the right part
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node above;
        while (curr != null) {
            above = curr.next;
            curr.next = prev;
            prev = curr;
            curr = above;
        }
        Node right_head = prev;

        // Now combine left and right part to form zig-zag
        // Node temp = new Node(-1);
        // Node zz_list = temp;
        // while (head.next != null && right_head.next != null) {
        //     // keep one from left part
        //     zz_list.next = head;
        //     head = head.next;
        //     zz_list = zz_list.next;

        //     // Keep other from Right part
        //     zz_list.next = right_head;
        //     right_head = right_head.next;
        //     zz_list = zz_list.next;

        // }

        // return temp.next;

        //Other Approach 
        Node nextL,nextR;
        while (head!=null && right_head != null) {
            nextL = head.next;
            nextR = right_head.next;

            head.next = right_head;
            right_head.next = nextL;

            head = nextL;
            right_head = nextR;
        }
    }

    void print() {
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
        linkedlist ll = new linkedlist();
        ll.add_first(-6);
        ll.add_first(9);
        ll.add_last(8);
        ll.add_last(7);
        ll.add_last(1);
        ll.add_last(5);

        ll.print();

        ll.zik_zak(head);
        ll.print();
        System.out.println("Size: " + size);

    }
}
