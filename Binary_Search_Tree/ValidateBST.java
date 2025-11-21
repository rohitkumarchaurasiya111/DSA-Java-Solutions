
public class ValidateBST {
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

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // We can use two approach to find this
    // Approach-1 : Do Inorder Travesal of BST and if Inorder Traversal is sorted
    // then it is valid BST

    // Aprroach-2 : We set min and max for each node and find if the current node is
    // between it's min and max
    static boolean isValidBST(Node root, Node max, Node min) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data > max.data) {
            return false;
        }

        boolean left_valid = isValidBST(root.left, root, min);
        boolean right_valid = isValidBST(root.right, max, root);
        return left_valid && right_valid;
    }

    public static void main(String[] args) {
        int Values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < Values.length; i++) {
            root = insert(root, Values[i]);
        }
        System.out.println(isValidBST(root, null, null));
    }
}
