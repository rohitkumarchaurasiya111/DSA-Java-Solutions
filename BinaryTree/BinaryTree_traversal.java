package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_traversal {

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

    static class Binarytree {
        static int index = -1;

        public Node BuildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }

        public void preOrderTraversal(Node root) {
            if (root == null) {
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void LevelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currentNode = q.remove();
                if (currentNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null)
                        q.add(currentNode.left);
                    if (currentNode.right != null)
                        q.add(currentNode.right);
                }
            }
        }

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> parent = new LinkedList<>();
            List<Integer> child = new LinkedList<>();
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    parent.add(child);
                    child = new LinkedList<>();

                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    child.add(currNode.data);
                    if (currNode.left != null)
                        q.add(currNode.left);
                    if (currNode.right != null)
                        q.add(currNode.right);
                }
            }
            return parent;
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public int count(Node root) {
            if (root == null) {
                return 0;
            }
            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;
        }

        public int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int lsum = sum(root.left);
            int rsum = sum(root.right);
            return lsum + rsum + root.data;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Binarytree bt = new Binarytree();
        Node root = bt.BuildTree(nodes);
        bt.preOrderTraversal(root);
        System.out.println();
        bt.inOrderTraversal(root);
        System.out.println();
        bt.postOrderTraversal(root);
        System.out.println();
        bt.LevelOrderTraversal(root);
        System.out.println();
        System.out.println(bt.levelOrder(root));
        System.out.println();
        System.out.println(bt.height(root));
        System.out.println();
        System.out.println(bt.count(root));
        System.out.println();
        System.out.println(bt.sum(root));
    }
}
