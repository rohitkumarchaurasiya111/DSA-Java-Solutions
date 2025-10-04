package Binary_Search_Tree;
//Range Sum of BST

// We have a Binary Search Tree consisting of N nodes and two positive integers L and R, the task is to find the sum of values of all the nodes that lie in the range [L, R]..

public class RangeSumBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int rangesum(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int leftSum = rangesum(root.left, low, high);
        int rightSum = rangesum(root.right, low, high);
        if (root.data >= low && root.data <= high) {
            return root.data + leftSum + rightSum;
        }
        return 0 + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        int low = 7;
        int high = 15;
        System.out.println(rangesum(root, low, high));
    }
}
