public class AVL_Tree_Insertion{

    //Class to represent the Node
    static class Node{
        int data;
        int height;     //To calculate Balance Factor
        Node left,right;

        public Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;    //The root node - The node having childrens but no parents
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
         *       AVL Tree (Output)
         *          30
         *         /    \
         *        20    40
         *       /  \     \
         *      10  25     50
         */

        //Looking if we got the correct answer or not
        preorder(root);
    }

    //Function to insert the nodes into AVL Tree
    public static Node insert(Node root, int data){
        if(root == null){       //Initially, when the root is null
            return new Node(data);
        }

        if(root.data > data){           //If data is less than root it will get inserted in left side
            root.left = insert(root.left, data);
        }else if(root.data < data){     //If data is more than root it will get inserted in right side
            root.right = insert(root.right, data);
        }else{
            return root;                //In Standard AVL, duplicate values are not allowed. So, return the original root.
        }

        //After Insertion -> Update the height of the root
        //Height = Maximum of Left side height, right side height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));    //Since, it is an recursive function, So, the height of all the ancestors get updated

        //Check the balance factor for this root, if it is in range or not
        int bf = getBalanceFactor(root);

        //Left Left Case
        if(bf > 1 && data < root.left.data)
            return rotateRight(root);

        //Right Right Case
        if(bf < -1 && data > root.right.data)
            return rotateLeft(root);

        //Left Right Case
        if(bf > 1 && data > root.left.data){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        //Right Left Case
        if(bf < -1 && data < root.right.data){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;    //This is the Balanced BST -> AVL Tree
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

    //Pre Order Traversal
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}