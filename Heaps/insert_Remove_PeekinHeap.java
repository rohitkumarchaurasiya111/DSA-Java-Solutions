package Heaps;

import java.util.ArrayList;

public class insert_Remove_PeekinHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        void add(int num) {
            arr.add(num); // Insert the num at last

            int x = arr.size() - 1; // Num is added at this node
            int parent = (x - 1) / 2; // This is it's parent
            while (arr.get(parent) > arr.get(x)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
                if (parent < 0) {
                    break;
                }
            }
        }

        int peek() { // Since,We have implemented MinHeap. So, It gives the minimum value
            return arr.get(0);
        }

        int remove() {

            int del = arr.get(0); // First Element is selected to delete

            // Swap first and last
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, del);

            // Delete last node
            arr.remove(arr.size() - 1);

            // Heapify
            Heapify(0);
            return del;
        }

        void Heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIndex = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIndex)) {
                minIndex = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIndex)) {
                minIndex = right;
            }
            if (minIndex != i) { // If minimum Index is changed i.e. the root is not the smallest then we need to
                                 // change
                // Swap i and minIndex as i is root. So, it should be the minimum
                int temp = arr.get(minIndex);
                arr.set(minIndex, arr.get(i));
                arr.set(i, temp);

                Heapify(minIndex);
            }
        }

        void printArrayList() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        Heap obj = new Heap();
        obj.add(5);
        obj.add(3);
        obj.add(8);
        obj.add(2);
        obj.printArrayList();
        obj.remove();
        obj.printArrayList();

    }
}
