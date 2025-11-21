
public class PrintInRange {
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

    static Node BuildTree(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data < data) {
            root.right = BuildTree(root.right, data);
        } else {
            root.left = BuildTree(root.left, data);
        }
        return root;
    }

    static void printInRange(Node root, int k1, int k2) {
        // Here K1 is less than K2
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        }

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
        int vales[] = { 8, 6, 5, 4, 3, 2, 1, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < vales.length; i++) {
            root = BuildTree(root, vales[i]);
        }
        System.out.print("Tree elements are: ");
        inorder(root);
        System.out.println();
        printInRange(root, 5, 10);
    }
}
