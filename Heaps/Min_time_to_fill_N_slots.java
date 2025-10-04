package Heaps;
//Minimum time required to fill given N slots

import java.util.LinkedList;
import java.util.Queue;

// We have an integer N which denotes the number of slots, and an array arr[] consisting of K integers in the range [1, N] repreand. Each element of the array are in the range [1, N] which represents the indices of the filled slots. At each unit of time, the index with filled slot fills the adjacent empty slots. The task is to find the minimum time taken to fill all the N slots..
// Sample Input 1: N = 5, K = 5, arr[] = {1, 2, 3, 4, 5}
// Sample Output 1:1

public class Min_time_to_fill_N_slots {
    static int min_time_to_fill(int arr[], int N) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean done[] = new boolean[N + 1];
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            done[arr[i]] = true;
        }
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int curr = q.remove();
                if (curr - 1 >= 1 && done[curr - 1] != true) {
                    done[curr - 1] = true;
                    q.add(curr - 1);
                }
                if (curr + 1 <= N && done[curr + 1] != true) {
                    done[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            if (!q.isEmpty()) {
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 6, 2 };
        System.out.println(min_time_to_fill(arr, N));
    }
}
