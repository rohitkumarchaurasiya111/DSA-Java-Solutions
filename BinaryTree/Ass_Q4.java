package BinaryTree;

//Find All Duplicate Subtrees
// We have a binary tree, find all duplicate subtrees. For each duplicate subtree, we only need to return the root node of any one of them. Two trees are duplicates if they have the same structure with the same node values.
import java.util.HashMap;

public class Ass_Q4 {
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

    static HashMap<String, Integer> map = new HashMap<>();

    // To find duplicate we use hashmap and inorder travel
    // Here, We use a string to store the value as ((leftNodes)ownnode(RightNode))
    // at each nodes. and then we use hashmap to see if the value repeats. If the
    // value repeates then we print that node
    static String find_duplicate(Nodes root) {
        if (root == null) {
            return "";
        }
        String str = "(";
        str += find_duplicate(root.left);
        str += root.data;
        str += find_duplicate(root.right);
        str += ")";

        // check if the string is already in our Hashmap or not
        if (map.get(str) != null && map.get(str) == 1) {
            System.out.print(str + " ");
        }

        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
        return str;
    }

    public static void main(String[] args) {
        Nodes root = new Nodes(1);
        root.left = new Nodes(4);
        root.right = new Nodes(3);
        root.left.left = new Nodes(3);

        root.right.left = new Nodes(4);
        root.right.right = new Nodes(3);
        root.right.left.left = new Nodes(3);
        find_duplicate(root);
    }
}
