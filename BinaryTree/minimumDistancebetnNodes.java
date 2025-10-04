package BinaryTree;

public class minimumDistancebetnNodes {
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

    static int Distance(Nodes root, int p) {
        if (root == null) {
            return -1;
        }
        if (root.data == p) {
            return 0;
        }
        int leftSide = Distance(root.left, p);
        int RightSide = Distance(root.right, p);
        if (leftSide == -1 && RightSide == -1) {
            return -1;
        } else if (leftSide == -1) {
            return RightSide + 1;
        } else {
            return leftSide + 1;
        }
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(2);
        root.left.left = new Nodes(3);
        root.left.right = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        int p = 3;
        int q = 6;
        Nodes lowest = LCA(root, p, q);
        int dist1 = Distance(lowest, p);
        int dist2 = Distance(lowest, q);
        System.out.println(dist1 + dist2);
    }
}
