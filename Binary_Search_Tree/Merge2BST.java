package Binary_Search_Tree;

import java.util.ArrayList;

public class Merge2BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode merge2(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        Inorder(root1, arr1);
        int i = 0;

        ArrayList<Integer> arr2 = new ArrayList<>();
        Inorder(root2, arr2);
        int j = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            arr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            arr.add(arr2.get(j));
            j++;
        }

        TreeNode root = BSTfromSortedArray(arr, 0, arr.size() - 1);
        return root;
    }

    static TreeNode BSTfromSortedArray(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = BSTfromSortedArray(arr, si, mid - 1);
        root.right = BSTfromSortedArray(arr, mid + 1, ei);
        return root;
    }

    static void Inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        Inorder(root.left, arr);
        arr.add(root.val);
        Inorder(root.right, arr);
    }

    static void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.val + " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(12);

        TreeNode root = merge2(root1, root2);
        Inorder(root);
    }
}
