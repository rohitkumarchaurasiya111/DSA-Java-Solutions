package BinaryTree;

public class kth_Level_of_tree {
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

    static void kth_terms(Nodes root, int level, int k) {
        // Doing pre_order Traversal
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kth_terms(root.left, level + 1, k);
        kth_terms(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        int k = 3;
        kth_terms(root, 1, k);
    }
}
