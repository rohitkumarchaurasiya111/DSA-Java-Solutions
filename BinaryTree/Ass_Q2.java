package BinaryTree;

//Invert Binary Tree
// Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged./

public class Ass_Q2 {
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

    static void invertBinarTree(Nodes root) {
        if (root == null) {
            return;
        }
        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinarTree(root.left);
        invertBinarTree(root.right);
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);

        invertBinarTree(root);
    }
}
