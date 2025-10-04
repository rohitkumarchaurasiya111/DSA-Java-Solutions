package Binary_Search_Tree;

//Find k-th smallest element in BST
// We have the root of a binary search tree and K as input, find Kth smallest element in BST.

public class kthsmallestElement {
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

    static int count = 0;
    static Node kthSmallestinBST(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node left = kthSmallestinBST(root.left, k);
        if (left!=null) {
            return left;        //If we get some valid node form left side then it is returned as answer
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthSmallestinBST(root.right, k);

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        int k = 2;
        Node res = kthSmallestinBST(root,k);
        System.out.println(res.data);
    }
}
