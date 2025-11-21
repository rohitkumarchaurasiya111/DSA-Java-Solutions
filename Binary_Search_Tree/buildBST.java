
public class buildBST {
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

    static Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // Insert at Left Side
            root.left = Insert(root.left, val);
        } else {
            // Right Side
            root.right = Insert(root.right, val);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int Values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < Values.length; i++) {
            root = Insert(root, Values[i]);
        }
        inorder(root);
    }
}
