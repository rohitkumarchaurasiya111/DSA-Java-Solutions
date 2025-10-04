package Greedy_Algorithm;
//Kth largest odd number in a given range

// We have two variables L and R, indicating a range of integers from L to R inclusive, and a number K, the task is to find Kth largest lowodd number. If K > number of odd numbers in the range L to R then return 0.
// Sample Input 1: L = -3, R = 3, K = 1
// Sample Output 1:3

public class Ass_Q2 {
    public static void main(String[] args) {
        kthLargest(-5, -3, 2);
    }

    static void kthLargest(int l, int h, int k) {
        k=k-1;
        if (k < 0) {
            return;
        }
        int ans = 0;
        {
            int count = (int) Math.ceil((h - l + 1) / 2); // THis will give the no. of odd in between - Math.ceil will
                                                          // round off the number to it's next integer.
            if (k > count) {
                return;
            }
            ans = (h % 2 == 0) ? h - 1 - 2 * k : h - 2 * k;
        }
        System.out.println(ans);
    }
}
