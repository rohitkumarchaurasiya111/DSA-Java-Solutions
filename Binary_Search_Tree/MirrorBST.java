package Binary_Search_Tree;

public class MirrorBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node Insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = Insert(root.left, data);
        } else {
            root.right = Insert(root.right, data);
        }
        return root;
    }

    static Node mirrorBST(Node root) {
        if (root == null) {
            return root;
        }
        root.right = mirrorBST(root.left);
        root.left = mirrorBST(root.right);
        return root;

    }

    public static void main(String[] args) {
        Node root = null;
        Insert(root, 8);
        Insert(root, 5);
        Insert(root, 10);
        Insert(root, 3);
        Insert(root, 6);
        Insert(root, 11);

        Node root_mirror = mirrorBST(root);
    }
}
