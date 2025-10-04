package Array_2D;

// Print the number of 7’s that are inthe 2d array.
public class No_of_occurance {
    public static void main(String args[]) {
        int arr[][] = { { 4, 7, 8 }, { 8, 8, 7 } };
        int target = 7;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    count++;
                }
            }
        }
        System.out.println("The No. of Occurance of " + target + " is: " + count);
    }
}
