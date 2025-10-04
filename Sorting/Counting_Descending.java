package Sorting;

public class Counting_Descending {
    public static void main(String args[]) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        int Count[] = new int[findMax(arr) + 1];
        for (int i = 0; i < arr.length; i++) {
            Count[arr[i]]++;
        }

        // for (int i = 0; i < Count.length; i++) {
        //     System.out.print(Count[i] + " ");
        // }
        
        System.out.println();
        int j = 0;
        for (int i = Count.length - 1; i >= 0; i--) {
            while (Count[i] > 0) {
                arr[j] = i;
                j++;
                Count[i]--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int findMax(int arr[]) {
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Max = Math.max(Max, arr[i]);
        }
        return Max;
    }
}
