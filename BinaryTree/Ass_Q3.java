package BinaryTree;

//Delete leaf nodes with values as x
// We have a binary tree and a target integer x, delete all the leaf nodes having value as x. Also, delete the newly formed leaves with the target value as x.

public class Ass_Q3 {
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

    static boolean isLeaf(Nodes root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    static Nodes remove_leaf_node(Nodes root, int key) {
        if (root == null) {
            return null;
        }
        root.left = remove_leaf_node(root.left, key);
        root.right = remove_leaf_node(root.right, key);

        if (isLeaf(root) && root.data == key) {
            return null;
        }
        return root;

    }

    static void preOrderTraversal(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(6);

        remove_leaf_node(root, 4);
        preOrderTraversal(root);
    }
}
