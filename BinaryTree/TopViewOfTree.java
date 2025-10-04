package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {
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

    static class Info {
        Node node;
        int hd; // Horizontal Distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static class BinaryTree {
        public void topview(Node root) {
            HashMap<Integer, Node> map = new HashMap<>();
            int min_val = 0, max_val = 0;
            // Level order traversal

            Queue<Info> qu = new LinkedList<>();
            qu.add(new Info(root, 0));
            qu.add(null);

            while (!qu.isEmpty()) {
                Info current = qu.remove();
                if (current == null) {
                    // System.out.println();
                    if (qu.isEmpty()) {
                        break;
                    } else {
                        qu.add(null);
                    }
                } else {
                    if (!map.containsKey(current.hd)) {
                        map.put(current.hd, current.node);
                    }

                    if (current.node.left != null) {
                        qu.add(new Info(current.node.left, current.hd - 1));
                        min_val = Math.min(min_val, current.hd - 1);
                    }
                    if (current.node.right != null) {
                        qu.add(new Info(current.node.right, current.hd + 1));
                        max_val = Math.max(max_val, current.hd + 1);
                    }
                }
            }

            for (int i = min_val; i <= max_val; i++) {
                Node curr = map.get(i);
                System.out.print(curr.data + " ");
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTree obj = new BinaryTree();
        obj.topview(root);
    }
}
