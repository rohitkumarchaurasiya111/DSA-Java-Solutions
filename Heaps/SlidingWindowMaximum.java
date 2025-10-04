package Heaps;
//Sliding Window Maximum 

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Maximum of all Subnumsays of Size K

public class SlidingWindowMaximum {
    static class comp implements Comparable<comp> {
        int value;
        int index;

        public comp(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(comp obj2) {
            return this.value - obj2.value;
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int res[] = new int[nums.length - k + 1];
        PriorityQueue<comp> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int i = 0;
        // First add k elements to pq
        for (; i < k; i++) {
            pq.add(new comp(nums[i], i));
        }

        int ind = 0;
        res[ind] = pq.peek().value;

        for (; i < nums.length; i++) {
            pq.add(new comp(nums[i], i));
            comp max = pq.peek();
            while (max.index <= i - k) {
                pq.remove();
                max = pq.peek();
            }
            res[++ind] = max.value;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int K = 3;
        int arr[] = maxSlidingWindows(nums, K);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    // Here, is an other approach where we can solve the question in 0(n) Time
    // Complexity
    // We use Deque Data Structure here

    public static int[] maxSlidingWindows(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int ind = -1;
        for (int i = 0; i < nums.length; i++) {

            // If left most index is not valid then we remove it
            while (dq.size() > 0 && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // If right most is not valid then we remove it and also if it's value is less
            // than the element we are going to insert then it is safe to remove it as it
            // will not contribute on maximum number
            while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            // If the current element is the maximum element then it will automatically go
            // at the left due to above condition where we are removing all right most
            // elements less than current element
            // So, We add the element at last
            dq.addLast(i);

            if (i >= k - 1) // this condition for just for the first time to check before writing the result
                            // we have initial k elemnts in our window or not
                res[++ind] = nums[dq.peekFirst()]; // The element at the fist will always be maximum and valid due to above
                                             // condiitons.
        }
        return res;
    }
}
