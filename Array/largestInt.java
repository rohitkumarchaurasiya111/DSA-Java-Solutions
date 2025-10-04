package Array;

public class largestInt {
    public static void main(String args[]) {
        int arr[] = { 3, 2, 8, 100, 99 ,123};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum Value is: " + max);
    }
}
