
//T.C = O(n*w);
//Using logic similar to 0/1 Knapsack problem
//Here, we will either include a number or exclude based on certain conditions
public class TargetSumSubset {
    public static void main(String[] args) {
        int num[] = {4,2,7,1,3};
        int target = 10;
        System.out.println(targetSumRecursion(num, target, 0, 0));  //Recursion
        tabulationSolutionOfTargetSumSubset(num, target);                     //DP
    }

    public static boolean targetSumRecursion(int num[], int target, int i, int currSum){
        if(currSum == target)   return true;
        if(i >= num.length)  return false;
        if(currSum + num[i] <= target){     //Valid Case
            //Choose
            boolean ans1 = targetSumRecursion(num, target, i+1, currSum+num[i]);
            //Not Choose
            boolean ans2 = targetSumRecursion(num, target, i+1, currSum);
            return ans1 || ans2;
        }else{
            return targetSumRecursion(num, target, i+1, currSum);
        }
    }

    //Tabulation in Dp -> taking boolean dp[] and looking if sum can be achieved or not 
    //Here, i = items 
    // j = target sum
    //Base case, if sum = 0, then whatever be our items we can get 0 sum. So, keep true for j = 0
    //If items = 0, then whatever be the sum, we cannot achieve. so, i = 0, keep false which is there by default
    //Here, we will store true of false, i.e. either the target value can be achieved or not 
    //Dp[i][j] meaning using i items can we get sum equal j only using subset upto i items
    public static void tabulationSolutionOfTargetSumSubset(int num[], int target){
        boolean dp[][] = new boolean[num.length + 1][target + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0) dp[i][j] = true;   //target sum = 0, can be always achieved
                //Include
                if(num[i-1]<=j && dp[i-1][j-num[i-1]] == true){     //if num[i-1] = 3 and j = 5. So, we can keep three, now we will check if 5-3, 2 was achieved earlier, if yes, then 5 can also be achieved
                    dp[i][j] = true;
                }
                //Exclude
                else if(dp[i-1][j] == true)
                    dp[i][j] = true;
            }
        }
        System.out.println(dp[num.length][target]);
    }
}
