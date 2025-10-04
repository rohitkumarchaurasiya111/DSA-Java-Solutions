package Greedy_Algorithm;

//Split the given array into K sub-arrays
// We have an Array of N elements and a number K. (1 <= K <= N). Split the given array into K subarrays (they must cover all the elements). The maximum subarray sum achievable out of K subarrays formed must be the minimum possible. Find that possible subarray sum.
// Sample Input 1:Array[] = {1, 1, 2} K = 2
// Sample Output 1:2
// Sample Input 2: Array[] = {1, 2, 3, 4}, K = 3
// Sample Output 2:4

public class Ass_Q5 {
    public static void main(String[] args) {
        int Array[] = { 1, 17, 14, 9, 15, 9, 14 }, K = 7;
        System.out.println(Min_Sum(Array, K));
    }

    static int Min_Sum(int array[], int k) {
        int min_sum = 0;
        int max_sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (min_sum < array[i]) {
                min_sum = array[i]; // To find maximum in that array;
            }
            max_sum += array[i];
        }

        // while (min_sum <= max_sum) { //Since, here we will have to go from min_sum to
        // max_sum. So, the complexity will increase. Hence, we will use binary search
        // for this purpost
        // int count = students_count(array, min_sum);
        // if (count == k) {
        // return min_sum;
        // }
        // min_sum++;
        // }

        while (min_sum <= max_sum) {
            int mid = max_sum - (max_sum - min_sum) / 2;
            int count = students_count(array, mid);
            if (count > k) {
                min_sum = mid + 1;
            } else {
                max_sum = mid - 1;
            }
        }
        return min_sum;

    }

    static int students_count(int array[], int val) {
        int sum = 0;
        int sub_array_count = 1;
        for (int i = 0; i < array.length; i++) {
            if (sum + array[i] <= val) {
                sum += array[i];
            } else {
                sub_array_count++;
                sum = array[i];
            }
        }
        return sub_array_count;
    }
}
