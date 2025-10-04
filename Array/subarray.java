package Array;

public class subarray {
    public static void main(String args[]) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int n = arr.length;
        int arr_sum[] = new int[n * (n + 1) / 2];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    arr_sum[temp] += arr[k];
                    System.out.print(arr[k] + " ");

                }
                System.out.print("= " + arr_sum[temp]);
                temp++;
                System.out.println();
            }
            System.out.println();
        }

        // maximum in array of sum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr_sum.length; i++) {
            if (arr_sum[i] > max) {
                max = arr_sum[i];
            }
        }
        System.out.println("The Maximum Sum is: " + max);

        // minimum in array of sum
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr_sum.length; i++) {
            if (arr_sum[i] < min) {
                min = arr_sum[i];
            }
        }
        System.out.println("The Minimum Sum is: " + min);
    }
}
