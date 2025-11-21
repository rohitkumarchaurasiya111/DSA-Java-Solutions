
public class deleteBST {
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

    static Node findInordersucessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        // Search for the node to delete
        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.data == key) {
            // In this case, we need to delete the data

            // Case-1 :- Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case-2 :- Only one child Node
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Case-3 :- if delete node is the middle node i.e has both left and right
            // parent
            // find Inorder sucessor
            Node IS = findInordersucessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        int Values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < Values.length; i++) {
            root = insert(root, Values[i]);
        }
        Inorder(root);
        System.out.println();
        root = deleteNode(root, 1);
        Inorder(root);
    }
}
