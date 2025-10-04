package Array;

public class binarySearch {
    public static int binSearch(int arr[], int key) {
        int s = 0;
        int e = arr.length -1;
        while (s<=e) {
            int mid = s + (e-s)/2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid]>key) {
                e = mid-1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int age[] = { 3,10,22,44,50,74,80 };
        int key = 74;
        int index = binSearch(age, key);
        if (index == -1) {
            System.out.println(key + " Doesnot Exist!");
        } else {
            System.out.println(key + " Exist at Index " + index);
        }
    }
}
