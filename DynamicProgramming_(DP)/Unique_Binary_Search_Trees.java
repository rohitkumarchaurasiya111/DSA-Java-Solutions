//Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
// leetcode - 96

//this problem is similar to our catalan's Number problem. we have to find the catalan number for give no. of nodes. 
public class Unique_Binary_Search_Trees {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Using Tabulation in DP: " + numTrees(n));
    }

    //Using Tabulation in DP
    public static int numTrees(int n) {
        int dp[] = new int[n+1];
        //Initialization
        dp[0] = 1;      //if we take 0 nodes, there is only one way to form BST i.e. null BST 
        dp[1] = 1;      //if we take 1 nodes, there is one way to form BST i.e. choosen node is the root

        for (int i = 2; i < dp.length; i++) {       //total nodes
            for (int j = 0; j < i; j++) {       //taking this j node as a root
                int left = dp[j];               //left side combination possible if root node is j
                int right = dp[i-1-j];          //right side combination posssible if root node is j
                dp[i] += left * right;          //total comibnations possible
            }
        }
        return dp[n];
    }
}
