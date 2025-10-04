package Array;

public class MaxSumusingPrefix {
    public static void main(String args[]) {
        int arr[] = { 1, -2, 6, -1, 3 };
        int prefix[] = new int[arr.length];
        // Here,we calculate prefix array
        // for (int i = 0; i < prefix.length; i++) {
        // int sum = 0;
        // for (int j = 0; j <= i; j++) {
        // sum += arr[j];
        // }
        // prefix[i] = sum;
        // }

        // More optimized process to calculate prefix sum
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // find max sum;
        // sum betwenn 1-3 is prefix[3] - prefix[1-1];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < prefix.length; i++) {
            // start = i;
            for (int j = i; j < prefix.length; j++) {
                // end = j;
                sum = (i == 0 ? prefix[j] : prefix[j] - prefix[i - 1]);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println("The Max Sum is: " + max);
    }
}
