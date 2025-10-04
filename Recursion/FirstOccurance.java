package Recursion;

public class FirstOccurance {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 4, 5, 6, 7 ,5};
        int key = 5;
        System.out.println(occur(arr, key, 0));
    }

    public static int occur(int arr[], int key, int i) {
        if (arr[i] == key) {
            return i;
        }
        if (i == arr.length - 1) {
            return -1;
        }
        return occur(arr, key, i + 1);
    }
}
