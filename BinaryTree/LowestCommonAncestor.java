package BinaryTree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    static class Nodes {
        int data;
        Nodes left;
        Nodes right;

        public Nodes(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static boolean getPath(Nodes root, int n, ArrayList<Integer> arr) {
        if (root == null) {
            return false;
        }
        arr.add(root.data);
        if (root.data == n) {
            return true;
        }
        boolean leftFound = getPath(root.left, n, arr);
        boolean rightFound = getPath(root.right, n, arr);
        if (leftFound || rightFound) {
            return true;
        }
        arr.remove(arr.size() - 1);
        return false;
    }

    // Other Approach - Using Sub-Tree
    // Here, We find the last sub-tree where both the values lie
    static Nodes LCA(Nodes root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Nodes leftSide = LCA(root.left, n1, n2);
        Nodes rightSide = LCA(root.right, n1, n2);

        if (rightSide == null) {
            return leftSide;
        }

        if (leftSide == null) {
            return rightSide;
        }
        return root;

    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);

        int n1 = 4, n2 = 3;
        ArrayList<Integer> arr1 = new ArrayList<>();
        getPath(root, n1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getPath(root, n2, arr2);

        int lowestCommon = root.data;
        for (int i = 0; i < arr1.size() && i < arr2.size(); i++) {
            if (arr1.get(i) == arr2.get(i)) {
                lowestCommon = arr1.get(i);
            }
        }
        System.out.println(lowestCommon);
        

        Nodes common = LCA(root, n1, n2);
        System.out.println(common.data);
    }
}
