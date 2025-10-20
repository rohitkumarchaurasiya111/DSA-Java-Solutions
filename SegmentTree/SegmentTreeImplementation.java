package SegmentTree;

public class SegmentTreeImplementation {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        
        //Building Segment Tree
        int tree[] = new int[4*n];      //Array to store the Segment Tree
        buildST(arr, 0, n-1, tree, 0);      //Building BST
        
        //Getting the sum between ranges (Queries on ST)
        int i = 2, j = 5;       //Range to get sum of
        int sum = getSum(i, j, tree, 0, n-1, 0);
        System.out.println("Sum of Range: " + sum);

        //Updating on ST
        i = 2;
        int newValue = 2;
        updateST(arr, i, newValue,tree);

        for (int k = 0; k < tree.length; k++) {
            System.out.print(tree[k] + " ");
        }
    }   

    //Function to Build Segment Tree
    //Time Complexity - O(n)
    public static int buildST(int arr[], int start, int end, int tree[], int indexTree){
        if(start == end){   //Leaf Nodes
            tree[indexTree] = arr[start];       //if leaf node then sum = itself
            return tree[indexTree];
        }
        //If node is not the leaf node then find the sum of all it's children
        int mid = (start + end)/2; 
        int left = buildST(arr, start, mid, tree, 2*indexTree + 1);         //give sum of left child
        int right = buildST(arr, mid + 1, end, tree, 2*indexTree + 2);      //give sum of right child
        tree[indexTree] = left + right;         //node in ST = sum of it's children
        return tree[indexTree];
    }

    //Function to get Sum of given range
    //CurrIndexOfTree -> Contains the sum of si to sj   e.g. TreeIndex 0 contains the sum of 0 to n-1
    //int i, j -> range to get sum of 
    //Time Complexity - O(logn)
    public static int getSum(int i, int j, int tree[], int si, int sj, int currIndexTree){
        //Case 1: No Overlap
        if(sj < i || si > j){
            return 0;       //We don't include this node
        }
        //Case 2: Complete Overlap
        else if(si >= i && sj <= j){    //We include this node
            return tree[currIndexTree];
        }
        //Case 3: Partial Overlap
        else{
            int mid = si + (sj-si)/2;
            int left = getSum(i, j, tree, si, mid, 2*currIndexTree+1);         //Call for left part
            int right = getSum(i, j, tree, mid + 1, sj, 2*currIndexTree+2);    //Call for right part
            return left + right;            //Sum of left + right part
        }
    }

    //Function to update Value
    //Time Complexity - O(n.logn)
    public static void updateST(int arr[], int i, int newValue, int tree[]){
        int diff = arr[i] - newValue;
        arr[i] = newValue;
        //CurrIndexOfTree -> Contains the sum of si to sj   e.g. TreeIndex 0 contains the sum of 0 to n-1
        updateStUtil(i, tree, 0, arr.length-1, 0, diff);
    }

    public static void updateStUtil(int i, int tree[], int si, int sj, int currIndexTree, int diff){
        //If i doesnot falls between si and sj
        if(si > i || sj < i) return;

        //If i falls between si and sj
        tree[currIndexTree] -= diff;    //Subtract the different from tree value to adjust the changes
        
        if(si!=sj){     //If we have not reached the leaf node yet, we have to update the other below nodes also
            int mid = si + (sj-si)/2;
            updateStUtil(i, tree, si, mid, 2 * currIndexTree + 1, diff);        //To update left node
            updateStUtil(i, tree, mid + 1, sj, 2 * currIndexTree + 2, diff);    //To update Right node
        }   
    }
}
