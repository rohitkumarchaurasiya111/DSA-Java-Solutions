package Binary_Search_Tree;

public class ClosestinBST {
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

    static int min_diff = Integer.MAX_VALUE;
    static Node min_Node = null;

    static void ClosestDiff(Node root, int target) {
        if (root == null) {
            return;
        }
        ClosestDiff(root.left, target);
        ClosestDiff(root.right, target);
        min_diff = Math.min(min_diff, Math.abs(root.data - target));
        if (min_diff == root.data - target) {
            min_Node = root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        int target = 5;
        ClosestDiff(root, target);
        System.out.println(min_Node.data);

    }
}