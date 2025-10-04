package Queue;
//Connect n ropes with minimum cost

import java.util.PriorityQueue;

// Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
// Sample Input 1: N = 4, arr = [4326]
// Sample Output 1:29

public class Ass_Q2 {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 4, 8, 6, 9 };
        System.out.println(find_min_cost(arr));
    }

    static int find_min_cost(int arr[]) {
        //Priority Queue is used in this case
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int total_cost = 0;
        while (pq.size() > 1) {
            int small1 = pq.poll();  //Gives smallest element in the Queue
            int small2 = pq.poll();
            int now_cost = small1 + small2;
            total_cost += now_cost;
            pq.add(now_cost);
        }
        return total_cost;
    }
}
