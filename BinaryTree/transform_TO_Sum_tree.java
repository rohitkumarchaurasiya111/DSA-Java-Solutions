package BinaryTree;

public class transform_TO_Sum_tree {
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

    static int sum_tree(Nodes root) {
        if (root == null) {
            return 0;
        }
        int leftSide_val = sum_tree(root.left);
        int rightSide_val = sum_tree(root.right);

        int data = root.data;
        root.data = leftSide_val + rightSide_val;
        return data + root.data;
    }

    static void pre_order(Nodes root){
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        pre_order(root.left);
        pre_order(root.right);
    }
    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);

        sum_tree(root);
        pre_order(root);
    }
}
