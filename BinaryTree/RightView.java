package BinaryTree;

//Right view of a BinaryTree
import java.util.*;

class RightView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        static void preOrder(TreeNode root, int level, List<Integer> arr) {
            if (root == null) {
                return;
            }

            if (level == arr.size()) {
                arr.add(root.val);
            }
            preOrder(root.right, level + 1, arr);
            preOrder(root.left, level + 1, arr);
        }

        public static List<Integer> rightSideView(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            preOrder(root, 0, arr);
            return arr;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(4);

            System.out.println(rightSideView(root));
        }
    }
}