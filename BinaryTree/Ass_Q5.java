package BinaryTree;
//Maximum Path Sum in a Binary Tree

// We have a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

public class Ass_Q5 {
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

    // we will use the same techniques as used to find maximum height of a tree. Here,
    // we will find left_max and Right_max

    static int max_val; // Making this global as we cannot pass value call by reference in java

    static int find_max(Nodes root) {
        if (root == null) {
            return 0;
        }

        int left_val = Math.max(0, find_max(root.left)); //If left_val is -ve then we will consider 0 as negative will decrease max_value
        int right_val = Math.max(0, find_max(root.right));
        max_val = Math.max(left_val + right_val + root.data, max_val);
        return (root.data + Math.max(left_val, right_val));

    }

    public static void main(String[] args) {

        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        max_val = Math.max(0, root.data);
        find_max(root);
        System.out.println(max_val);

    }
}
