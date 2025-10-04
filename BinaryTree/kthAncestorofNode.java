package BinaryTree;

public class kthAncestorofNode {
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

    static int find_kth_ancestor(Nodes root, int k, Nodes p) {
        if (root == null) {
            return -1;
        }
        if (root == p) {
            return 0;
        }
        int leftSide = find_kth_ancestor(root.left, k, p);
        int rightSide = find_kth_ancestor(root.right, k, p);

        if (leftSide == -1 && rightSide == -1) {
            return -1;
        }
        int max = Math.max(leftSide, rightSide);
        if (k == max + 1) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);

        int k = 1;
        find_kth_ancestor(root, k, root.right.right);

    }
}
