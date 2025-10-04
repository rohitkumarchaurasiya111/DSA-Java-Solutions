package Recursion;

public class LastOccurance {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        int key = 1;
        // System.out.println(last_occur(arr, key, arr.length-1));\
        System.out.println(last_occur(arr, key, 0));

    }

    // public static int last_occur(int arr[],int key,int i){
    //     if (arr[i] == key) {
    //         return i;
    //     }
    //     if (i == 0) {
    //         return -1;
    //     }
    //     return last_occur(arr, key,i-1);
    // }

    public static int last_occur(int arr[], int key,int i){
        if (i == arr.length) {
            return -1;
        }
        int isFound = last_occur(arr, key, i+1);
        if (isFound != -1) {
            return isFound;
        }
        if (arr[i]==key) {
            return i;
        }
        return -1;
        
    }
}
