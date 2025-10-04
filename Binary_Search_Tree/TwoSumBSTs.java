package Binary_Search_Tree;
//Two Sum BSTS

import java.util.Stack;

// Given a BST, transform it into a greater sum tree where each node contains sum of all nodes greater than that node.

// LeetCode 1214: Two Sum BSTs is a problem that involves finding if there exists a pair of nodes, one from each of two Binary Search Trees (BSTs), such that their sum equals a given target value.

public class TwoSumBSTs {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    static int count_possible_sum(Node root1, Node root2, int target) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        int count = 0;

        while (true) {
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }

            if (st1.isEmpty() || st2.isEmpty()) {
                break;
            }

            Node top1 = st1.pop();
            Node top2 = st2.pop();

            if ((top1.data + top2.data) == target) {
                System.out.println(top1.data + " " + top2.data);
                count++;
                root1 = top1.right;
                root2 = top2.left;
            } else if ((top1.data + top2.data) < target) {
                root1 = top1.right;
                st2.push(top2);
            } else {
                root2 = top2.left;
                st1.push(top1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;
        System.out.println("Total Count is: " + count_possible_sum(root1, root2, x));

    }
}
