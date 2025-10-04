package BinaryTree;

// Check if a Binary Tree is univalued or not
// We have a binary tree, the task is to check if the binary tree is univalued or not. If found to be true, then print "YES". Otherwise, print "NO".

public class Ass_Q1 {
    static class Nodes {
        int data;
        Nodes left;
        Nodes right;

        public Nodes(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static boolean univalued(Nodes root, int key) {
        // Do PreOrderTraversal
        if (root == null) {
            return true;
        }
        if (root.data != key) {
            return false;
        }
        boolean leftSide = univalued(root.left, key);
        boolean RightSide = univalued(root.right, key);
        return (leftSide && RightSide);
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(0);
        root.right = new Nodes(0);
        root.left.left = new Nodes(0);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(0);
        root.right.right = new Nodes(0);
        System.out.println(univalued(root, root.data));
    }
}
