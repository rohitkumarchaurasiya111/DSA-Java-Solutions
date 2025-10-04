package Heaps;

import java.util.PriorityQueue;

//Connect N Ropes
// Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
// ropes = {4, 3, 2, 6}
// ans = 29
public class ConnectNropes {

    static int min_cost_to_connect_ropes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int min_cost = 0;
        while (pq.size() > 1) {
            int new_rope = pq.remove() + pq.remove();
            min_cost += new_rope;
            pq.add(new_rope);
        }
        return min_cost;
    }

    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        System.out.println(min_cost_to_connect_ropes(ropes));
    }

}
