public class Red_Black_Tree_Insertion {
    public Node root;   //The starting node which has no parent;

    public Red_Black_Tree_Insertion(){      //Constructor
        root = null;
    }

    //Class to represent Node in Red Black Tree
    static class Node{
        int data;
        Node left;
        Node right;
        char colour;
        Node parent;

        public Node(int data){
            this.data = data;
            this.colour = 'R';  //Initally, the color is Red
        }
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,15,25,5,12,35,40,32,50};
        Red_Black_Tree_Insertion obj = new Red_Black_Tree_Insertion();
        for (int i = 0; i < arr.length; i++) {
            obj.insert(arr[i]);
        }

        preorder(obj.root);
    }

    //Function to insert data into the tree
    public void insert(int data){
        if(this.root == null){       //If main root Node is null
            this.root = new Node(data);
            this.root.colour = 'B';     //Colour of root Node is always Black
        }else{
            this.root = insertHelp(this.root,data);
        }
    }

    //These are the falgs 
    //Respective actions are performed during trackback based on the flags
    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    //Helper function for insertion. Actually this function performs all tasks in single pass only
    public Node insertHelp(Node root, int data){
        boolean redRedConflict = false;     //To keep track of red red conflict

        //Finding the position to keep our value
        if(root == null){
            return new Node(data);
        }else if(root.data > data){     //if root value is more then the value correct position is in the left side of root
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            if(root != this.root){      //If this is not the main root then there cannot occur Red Red Conflict
                if(root.colour == 'R' && root.left.colour == 'R')       //Checking if the red red conflict occures or not
                    redRedConflict = true;
            }
        }else {     //if root value is less than data then it's correct position is in right side
            root.right = insertHelp(root.right, data);
            root.right.parent = root;
            if(root != this.root){      //If this is not the main root then there cannot occur Red Red Conflict
                if(root.colour == 'R' && root.right.colour == 'R')       //Checking if the red red conflict occures or not
                    redRedConflict = true;
            }
        }
        //Above, At the same time of insertion, we are assigning parent node, also checking if the Red red conflict occurs or not

        //Now, Looking for Rotation
        if(this.rr){    //RR Case
            root = rotateLeft(root);
            //We change the colour of only whose positions are changed
            root.colour = 'B';
            root.left.colour = 'R';
            this.rr = false;
        }else if(this.ll){      //LL Case
            root = rotateRight(root);
            //We change the colour of only whose positions are changed
            root.colour = 'B';
            root.right.colour = 'R';
            this.ll = false;
        }else if(this.rl){
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            //We change the colour of only whose positions are changed
            root.colour = 'B';
            root.left.colour = 'R';
            this.rl = false;
        }else if(this.lr){
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            //We change the colour of only whose positions are changed
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }

        //When rotation and recolouring is done flags are reset.
        //Now lets take care of the RED RED conflict
        if(redRedConflict){
            //Checking which child of parent root it is, either left child or right child
            if(root.parent.right == root){   //if it is right child
                //Case - 1: Uncle Node is null or Black -> Rotation is done then Recoloring (done inside this differnt RL And RR blocks)
                if(root.parent.left == null || root.parent.left.colour == 'B'){
                    //Looking for which rotation needs to be done
                    if(root.left != null && root.left.colour == 'R')        //RL Case
                        this.rl = true;
                    else if(root.right != null && root.right.colour == 'R')   //RR Case
                        this.rr = true;
                }
                //Case - 2: Uncle Node is Red -> Recoluring is done
                else{
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if(root.parent != this.root)    //If root parent is not the root node then only it's colour will change
                        root.parent.colour = 'R';
                }
            }else{      //if it is left child
                //Case - 1: Uncle Node is null or Black -> Rotation is done then Recoloring (done inside this differnt LR And LL blocks)
                if(root.parent.right == null || root.parent.right.colour == 'B'){
                    //Looking for which rotation needs to be done
                    if(root.right != null && root.right.colour == 'R')        //RL Case
                        this.lr = true;
                    else if(root.left != null && root.left.colour == 'R')   //RR Case
                        this.ll = true;
                }
                //Case - 2: Uncle Node is Red -> Recoluring is done
                else{
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if(root.parent != this.root)    //If root parent is not the root node then only it's colour will change
                        root.parent.colour = 'R';
                }
            }
            redRedConflict = false;
        }
        return root;
    }

    //Function to rotate Left the AVL Tree
    //LL Case
    public static Node rotateRight(Node x){
        Node rootLeftNode = x.left;
        Node rootLeftNodeRightNode = rootLeftNode.right;

        //Rotation
        rootLeftNode.right = x;      //rootLeftNode becomes the new root Node now AND main root node goes to the right 
        x.left = rootLeftNodeRightNode;     //newRootNode.right becomes the main ROot Node left

        //Update Parent
        x.parent = rootLeftNode;
        if(rootLeftNodeRightNode != null)
            rootLeftNodeRightNode.parent = x;

        return rootLeftNode;    //rootLeftNode becomes the new root Node now
    }

    //RR Case
    public static Node rotateLeft(Node x){
        Node rootRightNode = x.right;
        Node rootRightLeftNode = rootRightNode.left;

        //Rotation
        rootRightNode.left = x;         //rootLeftNode becomes the new root Node now AND main root node goes to the left
        x.right = rootRightLeftNode;     //newRootNode.left becomes the mainRootNode right

        //Update Parents
        x.parent = rootRightNode;
        if(rootRightLeftNode != null)
            rootRightLeftNode.parent = x;

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
