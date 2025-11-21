
public class SearchBST {

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

    static boolean search(Node root, int val) {  //O(H)
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }

    }

    public static void main(String[] args) {
        int Values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < Values.length; i++) {
            root = Insert(root, Values[i]);
        }
        System.out.println(search(root, 4));
    }
}
