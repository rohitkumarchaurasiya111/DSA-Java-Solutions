
//Maximum Sum BST in Binary Tree

// We have a binary tree, the task is to print the maximum sum of nodes of a sub-tree which is also a Binary Search Tree.

//Here, We do the process same as done in SizeofLargestBSTinBT
public class MaximumSumBSTinBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    static class Info {
        boolean isValid;
        int max;
        int min;
        int curr_max;
        int sum;

        public Info(boolean isValid, int max, int min, int sum) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    static int max_sum = 0;

    static Info MaxSumBSTinBT(Node root) {
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Info left_info = MaxSumBSTinBT(root.left);
        Info right_info = MaxSumBSTinBT(root.right);

        int max = Math.max(Math.max(left_info.max, right_info.max), root.data);
        int min = Math.min(Math.min(right_info.min, left_info.min), root.data);
        int sum = left_info.sum + right_info.sum + root.data;

        if (root.data <= left_info.max || root.data >= right_info.min) {
            // This shows that it is not a BST
            return new Info(false, max, min, sum);
        }
        if (left_info.isValid && right_info.isValid) {
            max_sum = Math.max(max_sum, sum);
            return new Info(true, max, min, sum);
        }
        return new Info(false, max, min, sum);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

        MaxSumBSTinBT(root);
        System.out.println(max_sum);
    }
}
