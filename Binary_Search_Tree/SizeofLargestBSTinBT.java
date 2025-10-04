package Binary_Search_Tree;

public class SizeofLargestBSTinBT {
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

    static class Info {
        boolean isValidBST;
        int max;
        int min;
        int size;

        public Info(boolean isValidBST, int max, int min, int size) {
            this.isValidBST = isValidBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    static int largestSize = 0;

    static Info largestBSTSize(Node root) {
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Info leftinfo = largestBSTSize(root.left);
        Info rightinfo = largestBSTSize(root.right);

        int size = leftinfo.size + rightinfo.size + 1;
        int max = Math.max(Math.max(rightinfo.max, leftinfo.max), root.data);
        int min = Math.min(Math.min(leftinfo.min, rightinfo.min), root.data);

        // For IsValid BST or not
        if (root.data <= leftinfo.max || root.data >= rightinfo.min) { // IF not valid
            return new Info(false, max, min, size);
        }

        // Is left and right valid or not
        // If left and right are valid BST then only I am also valid BST
        if (leftinfo.isValidBST && rightinfo.isValidBST) {
            largestSize = Math.max(largestSize, size);
            return new Info(true, max, min, size);
        }
        return new Info(false, max, min, size);
    }

    public static void main(String args[]) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBSTSize(root);
        System.out.println(largestSize);
    }
}
