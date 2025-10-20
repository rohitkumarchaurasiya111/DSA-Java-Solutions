package SegmentTree;

// Max Min Element Queries
// Given an arr[ ], we have to answer few queries :
// a. Output Max/Min for the subarray [i..j]
// b. Update the element at idx

public class Max_Min_Element_Queries {
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length - 1;

        //Creating SegmentTree
        int tree[] = new int[4*n];
        createTree(arr, 0, arr.length - 1, tree, 0);

        //Print Tree
        System.out.println("Tree:");
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        //Query Between Ranges (Max between given ranges)
        System.out.println("Max: " + findMax(arr, 1, 2, tree));

        //Update 
        updateElement(arr, 2, 20, tree);

        //Print Tree
        System.out.println("Tree:");
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

    }

    //Creating Segment Tree
    public static int createTree(int arr[], int start, int end, int tree[], int i){     //T.C. - O(n)
        //Base Case
        if(start == end){       //Leaf Node
            tree[i] = arr[start];
            return tree[i];
        }

        //If the nodes are not the Leaf Nodes
        int mid = start + (end - start)/2;
        int left = createTree(arr, start, mid, tree, 2*i+1);
        int right = createTree(arr, mid+1, end, tree, 2*i+2);
        return tree[i] = Math.max(left,right);
    }

    //Queries on Segment Tree (Max. Between the given range)
    public static int findMax(int arr[], int i, int j, int tree[]){                     //T.C. O(logn)
        return findMaxUtil(arr, i, j, tree, 0, arr.length - 1, 0);
    }

    public static int findMaxUtil(int arr[], int i, int j, int tree[], int si, int sj, int currIndexOfTree){
        if(i == j){     //If the range is of only one node, then That is the result
            return arr[i];
        }
        //Case - 1, No overlap
        if(j < si || i > sj){
            return 0;
        }
        //Case - 2, Complete Overlap
        else if(si >= i && sj <= j){
            return tree[currIndexOfTree];
        }
        //Case - 3, Partial Overlap
        //We call it's left and right part to get the cases of complete or no overlap
        else{
            int mid = si + (sj-si)/2;
            int left = findMaxUtil(arr, i, j, tree, si, mid, 2*currIndexOfTree + 1);
            int right = findMaxUtil(arr, i, j, tree, mid + 1, sj, 2*currIndexOfTree+2);
            return Math.max(left,right);
        }
    }

    //Function to Update Elements
    public static void updateElement(int arr[], int i, int newValue, int tree[]){       //T.C. O(logn)
        
        arr[i] = newValue;
        updateElementUtil(arr, i, newValue, tree, 0, arr.length - 1, 0);
    }

    public static void updateElementUtil(int arr[], int i, int newValue, int tree[], int si, int sj, int currIndexOfTree){
        //If i doesnot lies under it (No Overlap)
        if(si > i || sj < i) return;
        
        //If i lies under it
        if(si == sj){       //If it is that leaf node to update, then update the newValue there
            tree[currIndexOfTree] = newValue;
        }
        if(si != sj){       //Only look for child, if it is not the leaf node
            tree[currIndexOfTree] = Math.max(tree[currIndexOfTree], newValue);
            int mid = si + (sj-si)/2;
            updateElementUtil(arr, i, newValue, tree, si, mid, 2*currIndexOfTree+1);
            updateElementUtil(arr, i, newValue, tree, mid+1, sj, 2*currIndexOfTree+2);
        }
    }
}
