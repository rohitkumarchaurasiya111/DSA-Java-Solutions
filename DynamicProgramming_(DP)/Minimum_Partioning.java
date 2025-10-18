//Minimum Partioning
//Given an array arr[]  containing non-negative integers, the task is to divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

//This problem is the Variation of 0-1 Knapsack problem 
//Here, we have to make two sets, where the differences between these two sets is minimum 
//For this to be possible, the sets should contains the value very closer to totalSum/2;
//In ideal case, sum of sets = totalSum/2;
//So, the capacity for one set would be totalSum/2 -> we cannot give more than this...
//and for each element we have choice either to choose that element or not. So, it is similar to 0/1 knapsack problem

public class Minimum_Partioning {
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        minDifference(arr);
    }

    public static void minDifference(int arr[]) {
        //Using Recursion -> Brute Force , looking all the possible combinations
        System.out.println("Using Recursion Brute Force: " + minDifferenceRecursion(arr, arr.length-1, 0,0));

        //Using 0-1 Knapsack - Recursion        //Here, We are treating one set as a bag with maximum capacity = totalSum/2 and each element has a choice to either come in the bag or not and our goal is to fill the bag as much as possible
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        int capacity = totalSum/2;      //this is the maximum a set1 can include to make minDifference
        int sum1 = minDifferenceKnapsack(arr, capacity, arr.length - 1);      //maximum value that can be filled in set1
        int sum2 = totalSum - sum1;         //value of set2 using set1
        System.out.println("Using Recursion Knapsack Logic: " + (sum2-sum1));

        //Using 0-1 Knapsack - Tabulation
        sum1 = minDifferenceKnapsackTabulation(arr, capacity);      //maximum value that can be filled in set1
        sum2 = totalSum - sum1;
        System.out.println("Using Tabulation 0-1 Knapsack Logic: " + (sum2-sum1));
    }

    //Using Recursion -> Brute Force , looking all the possible combinations
    public static int minDifferenceRecursion(int arr[], int i, int sum1, int sum2){
        if(i<0) return Math.abs(sum1-sum2);

        //keeping this in sum1;
        sum1+= arr[i];
        int minDiff = minDifferenceRecursion(arr,i-1, sum1,sum2);
        sum1-=arr[i];
        //keeping this in sum2;
        sum2 += arr[i];
        int minDiff2 = minDifferenceRecursion(arr, i-1, sum1,sum2);

        return Math.min(minDiff, minDiff2);
    }

    //Using the Logic of 0/1 Knapsack - Recursion
    public static int minDifferenceKnapsack(int arr[], int capacity, int i){        //return maximum we can fill 
        if(i < 0 || capacity == 0) return 0;
        if(capacity >= arr[i]){     //Valid Case to Include
            //Include
            int ans1 = arr[i] + minDifferenceKnapsack(arr, capacity-arr[i], i-1);
            //Exclude
            int ans2 = minDifferenceKnapsack(arr, capacity,i-1);
            return Math.max(ans1, ans2);
        }else{                      //Invalid Case
            //Exclude
            return minDifferenceKnapsack(arr, capacity,i-1);
        }
    }

    //Using the Logic of 0/1 Knapsack - Tabulation
    public static int minDifferenceKnapsackTabulation(int arr[], int capacity){
        int dp[][] = new int[arr.length + 1][capacity + 1];     //These two variables changes. it stores maximum filling capacity using given array in the bag

        //Initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }
        
        //Main Logic
        for (int i =  1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j >= arr[i-1]){      //valid case to include
                    //Include
                    int ans1 = arr[i-1] + dp[i-1][j - arr[i-1]];
                    //Exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{                  //exclude , Invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][capacity];
    }
}
