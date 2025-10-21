public class AVL_Tree_Deletion {
    //Class to represent the Node
    static class Node{
        int data;
        int height;     //To calculate Balance Factor
        Node left,right;

        public Node(int data){
            this.data = data;
            height = 1;         //For new Node, Height = 1
        }
    }
    public static Node root;    //The root node - The node having childrens but no parents
    public static void main(String[] args) {
        /*
         *       AVL Tree (Input)
         *          30
         *         /    \
         *        20    40
         *       /  \     \
         *      10  25     50
         */

        root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(40);
        root.left.left = new Node(10);
        root.left.right = new Node(25);
        root.right.right = new Node(50);

        // Checking Input Structure
        System.out.print("Before: " );
        preorder(root);
        System.out.println();

        delete(root, 40);
        System.out.print("After Deletion: ");
        preorder(root);
    }

    public static Node delete(Node root, int data){
        //Perform Normal BST Deletion First
        if(root == null) return null;
        
        if(data > root.data)
            root.right = delete(root.right,data);
        else if(data < root.data)
            root.left = delete(root.left, data);
        else if(data == root.data){     //if root node is the one we want to delete
            //NO Children
            if(root.left == null && root.right == null){
                root = null;
            }
            //Only one children
            else if(root.left == null || root.right == null){
                root =  (root.left == null)? root.right: root.left;  //if left side is null, it means right children is present. So, root = right children, if left side is present then root = left side.
            }
            //If both childrens present
            else{
                //Find inorder sucessor -> the smallest node in the right side of the tree
                Node inorderSucessor = findInordersucessor(root.right);
                root.data = inorderSucessor.data;
                root.right = delete(root.right, inorderSucessor.data);
            }
        }

        if(root == null) return root;
        
        //Height = Maximum of Left side height, right side height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));    //Since, it is an recursive function, So, the height of all the ancestors get updated

        //Check the balance factor for this root, if it is in range or not
        int bf = getBalanceFactor(root);

        //Since, Data is removed form the tree, We cannot use data here as in insertion.
        //So, We will use the BalanceFactor of it's left and right tree to see which rotation case should be applied
        //Left Left Case
        if(bf > 1 && getBalanceFactor(root.left) >= 0)
            return rotateRight(root);

        //Right Right Case
        if(bf < -1 && getBalanceFactor(root.right) <= 0)
            return rotateLeft(root);

        //Left Right Case
        if(bf > 1 && getBalanceFactor(root.left) < 0){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        //Right Left Case
        if(bf < -1 && getBalanceFactor(root.right) > 0){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    //Function to find Inorder sucessor -> the smallest node in the right side of the tree
    public static Node findInordersucessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //Function to get the height of the root
    public static int getHeight(Node root){
        if(root == null){       //if root is null, then no height
            return 0;
        }
        return root.height;
    }

    //Function to calculate balance factor of the root
    public static int getBalanceFactor(Node root){
        if(root == null){   //If root is null, bf = 0;
            return 0;
        }
        //Balance Factor = Height(Left child) - Height(Right Child)
        return getHeight(root.left) - getHeight(root.right);
    }

    //Function to rotate Left the AVL Tree
    //LL Case
    public static Node rotateRight(Node x){
        Node rootLeftNode = x.left;
        Node rootLeftNodeRightNode = rootLeftNode.right;

        //Rotation
        rootLeftNode.right = x;      //rootLeftNode becomes the new root Node now AND main root node goes to the right 
        x.left = rootLeftNodeRightNode;     //newRootNode.right becomes the main ROot Node left

        //Update Height
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        rootLeftNode.height = Math.max(getHeight(rootLeftNode.right) , getHeight(rootLeftNode.left)) + 1;

        return rootLeftNode;    //rootLeftNode becomes the new root Node now
    }

    //Function to rotate right the AVL Tree
    //RR Case
    public static Node rotateLeft(Node x){
        Node rootRightNode = x.right;
        Node rootRightLeftNode = rootRightNode.left;

        //Rotation
        rootRightNode.left = x;         //rootLeftNode becomes the new root Node now AND main root node goes to the left
        x.right = rootRightLeftNode;     //newRootNode.left becomes the mainRootNode right

        //Update Height
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        rootRightNode.height = Math.max(getHeight(rootRightNode.right) , getHeight(rootRightNode.left)) + 1;

        return rootRightNode;   //rootRightNode becomes the new root Node now
    }

    // Preorder Traversal to check structure
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}