package HashMap;
//Bottom view of a tree

//Here, we use Horizontal Distance Concept and Inorder Traversing
//While traversing in inorder we give each node a value, here, left = root.value -1 , right = root.value + 1.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bottom_View_of_Tree {
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
        Node root;
        int value;

        public Info(Node root, int value) {
            this.root = root;
            this.value = value;
        }
    }

    static void level_order_traversal_And_Bottom_View(Node root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Info currentNode = q.remove();
            if (currentNode == null) {
                //
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                hm.put(currentNode.value, currentNode.root);
                if (currentNode.root.left != null) {
                    q.add(new Info(currentNode.root.left, currentNode.value - 1));
                }
                if (currentNode.root.right != null) {
                    q.add(new Info(currentNode.root.right, currentNode.value + 1));
                }
            }
        }
        Set<Integer> keys = hm.keySet();
        for (Integer temp : keys) {
            Node temp_root = hm.get(temp);
            System.out.print(temp_root.data + " ");
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

        level_order_traversal_And_Bottom_View(root);
    }
}
