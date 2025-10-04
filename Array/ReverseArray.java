package Array;

public class ReverseArray {
    public static void reverse(int arr[]) {
        int n = arr.length - 1;
        // for (int i = 0; i < n / 2; i++) {
        // int temp = arr[i];
        // arr[i] = arr[n - i];
        // arr[n - i] = temp;
        // }
        int i = 0;
        while (i <= n) {
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            i++;
            n--;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 2, 4, 6, 8, 10, 12, 14 };
        reverse(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
