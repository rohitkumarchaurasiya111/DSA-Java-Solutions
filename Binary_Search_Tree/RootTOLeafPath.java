package Binary_Search_Tree;

import java.util.ArrayList;

public class RootTOLeafPath {
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

    static void root_to_leaf_path(Node root, ArrayList<Node> arr) {
        if (root == null) {
            return;
        }

        arr.add(root);
        root_to_leaf_path(root.left, arr);
        root_to_leaf_path(root.right, arr);
        if (root.left == null && root.right == null) {
            // Leaf Node
            System.out.print("Path: ");
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i).data + " ");
            }
            System.out.println();
        }
        arr.remove(root);
        

    }

    public static void main(String[] args) {
        int Values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < Values.length; i++) {
            root = insert(root, Values[i]);
        }
        ArrayList<Node> arr = new ArrayList<>();
        root_to_leaf_path(root, arr);

    }
}
