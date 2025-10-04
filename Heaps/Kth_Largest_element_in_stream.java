package Heaps;
// //K'th largest element in a stream

import java.util.PriorityQueue;

// We have an infinite stream of integers, find the k'th largest element at any point of time.
// Input: stream = {10, 20, 11, 70, 50, 40, 100, 5, ...} k = 3
// Output:,, 10, 11, 20, 40, 50, 50, ...}

public class Kth_Largest_element_in_stream {

    class kth_largest {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;

        public kth_largest(int arr[], int k) {
            this.k = k;
            for (int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }
            while (pq.size() > k) {
                pq.remove();
            }
        }

        int add(int value) {
            pq.add(value);
            while (pq.size() > k) {
                pq.remove();
            }
            return pq.peek();
        }
    }

}
