package BinaryTree;

public class diameter {
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

    static class BinaryTree {
        static int index = -1;

        public static Node BuildTree(int Nodes[]) {
            index++;
            if (Nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[index]);
            newNode.left = BuildTree(Nodes);
            newNode.right = BuildTree(Nodes);
            return newNode;

        }

        int height(Node root) { // O(n)
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        // This method has time complexity of n^2 as for diameter o(n) and for height at
        // each node o(n)
        int diameter(Node root) { // O(n^2)
            if (root == null) {
                return 0;
            }
            int left_diameter = diameter(root.left);
            int right_diameter = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int dia = lh + rh + 1;
            return Math.max(dia, Math.max(left_diameter, right_diameter));
        }

        // Since, We have to use more time to calculate height. Hence, to reduce this
        // time We use a class that contains info about the node so that we don't need
        // to call height function at each step
        static class Info {
            int diameter;
            int height;

            public Info(int diameter, int height) {
                this.diameter = diameter;
                this.height = height;
            }
        }

        Info diameter_optimized(Node root) { // O(n)
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter_optimized(root.left);
            Info rightInfo = diameter_optimized(root.right);

            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                    leftInfo.height + rightInfo.height + 1);

            Info final_Info = new Info(diameter, height);
            return final_Info;
        }
    }

    public static void main(String[] args) {
        int Nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // 1
        // / \
        // 2 4
        // / \ \
        // 4 5 6
        BinaryTree obj = new BinaryTree();
        Node root = obj.BuildTree(Nodes);
        System.out.println(obj.diameter(root));
        System.out.println(obj.diameter_optimized(root).diameter);
    }

}
