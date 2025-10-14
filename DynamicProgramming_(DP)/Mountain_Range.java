// Mountain Ranges
// Mountains & Valleys
// at any moment the number of down strokes cannot be more than number of up strokes.


//this question follows the concept of catalans's number
public class Mountain_Range {
    public static void main(String[] args) {
        int n = 3; //No. of up strokes and down strokes given
        System.out.println("Using Tabulation: " + noOfUniqueRangesPossible(n));
    }


    //Using Tabulation in DP
    public static int noOfUniqueRangesPossible(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;      //if no up strokes and down strokes then we have plane land, considering it as the one
        dp[1] = 1;      //if we have one up stroke and one down stroke, possible structure is one


        for (int i = 2; i < dp.length; i++) {   //no. of both strokes
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j]*dp[i-j-1];
            }
            dp[i] = ans;                    //possible unique structures for i no. of both strokes
        }
        return dp[n];
    }
}


