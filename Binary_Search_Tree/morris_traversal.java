//Morris Traversal

//T.C = O(n)
//S.C = O(1)
//So, it is more effective than any other traversal technique

public class morris_traversal {
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

    static void morrisTraversal(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " "); // Because it is root
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == curr) {
                    prev.right = null;
                    System.out.print(curr.data + " "); // Root value
                    curr = curr.right;
                } else {
                    prev.right = curr;
                    curr = curr.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);

        morrisTraversal(root);
    }
}
