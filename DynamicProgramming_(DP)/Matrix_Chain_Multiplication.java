//Matrix Chain Multiplication
//Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.
//for two matrix of dimensions (a*b) and (b*c), the no. of multiplication operations required are a*b*c and finally the output matrix will be of dimension (a*c)
//Here, dimension of Matrix i = arr[i-1] * arr[i]


public class Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        matrixMultiplication(arr);
    }

    public static void matrixMultiplication(int arr[]) {
        //Using Recursion
        System.out.println("Using Recursion: " + matrixMultiplicationRecursion(arr, 1, arr.length - 1));

        //Using Memoization in DP
        int dp[][] = new int[arr.length][arr.length];   //Minimum cost to form matric multiplication of (i,j);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Using Memoization: " + matrixMultiplicationMemoization(arr, 1, arr.length -1, dp));

        // Using Tabulation in DP
        System.out.println("Using Tabulation: " + matrixMultiplicationTabulation(arr));
    }


    // i = starting point
    // j = ending point
    // k = pointer that moves from starting to ending point
    //Here, K will divide my total matrices to 2 differnt parts and we already know how to multiply two parts


    //For Recursion, we use 3 variables here
    public static int matrixMultiplicationRecursion(int arr[], int i, int j){   //function returns the minimum cost
        if(i==j) return 0;  //multiplication of Matrix 1 * Matix 1 is no need to be done

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {       //to see through all the possible combination -> basically this divides our matrices, into multiple groups then we will calculate the minimum cost of the groups and see if this can achieve our goal or not
            int cost1 = matrixMultiplicationRecursion(arr, i, k);   //minimum cost to get matrix (i,k)
            int cost2 = matrixMultiplicationRecursion(arr, k+1, j); //minimum cost to get matrix (k+1, j)
            int cost3 = arr[i-1] * arr[k] * arr[j];          //cost to multiply matrix (i,k) and (k+1, j);
            minCost = Math.min(minCost, cost1 + cost2 + cost3);
        }
        return minCost;
    }


    //Using Memoization in DP
    public static int matrixMultiplicationMemoization(int arr[], int i, int j,int dp[][]){     //function returns the minimum cost
        if(i == j) return 0;    //we don't have to multiply same matrices

        if(dp[i][j] != -1) return dp[i][j];     //if already calculated return
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {     //to see through all the possible combination -> basically this divides our matrices, into multiple groups then we will calculate the minimum cost of the groups and see if this can achieve our goal or not
            int cost1 = matrixMultiplicationMemoization(arr, i, k, dp);   //minimum cost to get matrix (i,k)
            int cost2 = matrixMultiplicationMemoization(arr, k+1, j, dp);  //minimum cost to get matrix (k+1,j)
            int cost3 = arr[i-1] * arr[k] * arr[j];         //cost to multiply matrix (i,k) and (k+1, j);
            minCost = Math.min(minCost, cost1+cost2+cost3);
        }
        return dp[i][j] = minCost;
    }


    //Using Tabulation in DP
    public static int matrixMultiplicationTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];    //Minimum cost after multiplication of (i,j)

        //Initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;           //For len = 1 i.e. only one matrix, the cost of multiplication is 0 as we don't need to multiply
        }

        for (int len = 2; len < n; len++) {        //len = no. of matrixes taken or length of matrix chain
            for (int i = 1; i <= n-len; i++) {      //starting point  (row)
                int j = i+len - 1;                              //ending point (column)
                dp[i][j] = Integer.MAX_VALUE;               //Initialization
                for (int k = i; k < j; k++) {               //different combinations i.e. keeping parenthesis on differnt places and looking which will give me the least one
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j] , cost1 + cost2 + cost3);
                }
               
            }
        }
        return dp[1][dp[0].length - 1];       //this will contain all the multiplication cost from starting to the ending point i.e. the total cost
    }
}


