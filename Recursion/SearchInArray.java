package Recursion;

//ForagivenintegerarrayofsizeN.Youhavetofindalltheoccurrences(indices)ofagivenelement(Key)andprintthem.Usearecursivefunctiontosolvethisproblem
public class SearchInArray {
    public static void main(String args[]) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        findElement(arr, key, 0);
    }

    static void findElement(int arr[], int key, int i) {
        if (i >= arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i);
        }
        findElement(arr, key, i + 1);
    }
}
