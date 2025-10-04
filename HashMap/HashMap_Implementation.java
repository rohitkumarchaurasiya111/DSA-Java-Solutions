package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap_Implementation {
    static class MyHashMap<K, V> { // Here, <K,V> -> These are Generics, Generics are used when we are not sure of
                                   // the type used

        class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        int n; // n -> no of nodes
        int N; // N -> no of buckets
        LinkedList<Node> bucket[]; // Array of type LinkedList is made

        @SuppressWarnings("Unchecked")
        public MyHashMap() {
            this.n = 0; // Number of nodes
            this.N = 2; // Size of bucket
            this.bucket = new LinkedList[N];
            for (int i = 0; i < bucket.length; i++) {
                this.bucket[i] = new LinkedList<>(); // Each bucket has assigned empty linkedlist
            }
        }

        int hashIndexFinder(K key) {
            int index = key.hashCode();
            return index % N;

        }

        int searchNode(K key, int hash_index) {
            LinkedList<Node> temp = bucket[hash_index];

            for (int i = 0; i < temp.size(); i++) {
                Node check = temp.get(i);
                if (check.key == key) {
                    return i;
                }
            }
            return -1;
        }

        void rehash() {
            // Bucket data is stored in OldBucket
            LinkedList<Node> oldbucket[] = bucket;

            // Increasing the bucket size by 2 times
            bucket = new LinkedList[2 * N];
            N = 2 * N;

            // Each space in backet is initalized with empty linkedlist
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }

            // Keep the oldBucket values in new Bucket
            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> temp = oldbucket[i]; // This is the Linkedlist at Bucket Space

                // We go at the each nodes of a LinkedList and keep those nodes in newBucket
                while (temp.size() > 0) {
                    // Removing the nodes as we keep them in newBucket;
                    Node temp_node = temp.remove();
                    put(temp_node.key, temp_node.value);
                }
            }

        }

        public void put(K key, V value) {
            int hash_index = hashIndexFinder(key);
            int ll_node_index = searchNode(key, hash_index);

            if (ll_node_index == -1) { // The key is not present
                LinkedList<Node> temp = bucket[hash_index];
                temp.add(new Node(key, value));
                n++;
            } else {// If key is already present then we will simply update this
                LinkedList<Node> temp = bucket[hash_index];
                Node to_update = temp.get(ll_node_index);
                to_update.value = value; // Here, our exisiting node is update with new value
            }

            // To check the condition for ReHashing
            double lamda = (double) n / N;
            if (lamda > 2) { // We have 2 as a threshold value;
                rehash();
            }

        }

        public V get(K key) {
            int hash_index = hashIndexFinder(key);
            int ll_node_index = searchNode(key, hash_index);
            if (ll_node_index == -1) { // -1 means that the value is not present
                return null;
            } else { // If key is present then we will return it's value
                return bucket[hash_index].get(ll_node_index).value;
            }
        }

        public boolean containsKey(K key) {
            int hash_index = hashIndexFinder(key);
            int ll_node_index = searchNode(key, hash_index);
            if (ll_node_index == -1) {
                return false;
            }
            return true;
        }

        public V remove(K key) {
            int hash_index = hashIndexFinder(key);
            int ll_node_index = searchNode(key, hash_index);

            if (ll_node_index != -1) {
                Node temp = bucket[hash_index].remove(ll_node_index);
                n--;
                return temp.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> temp = bucket[i];

                for (Node temp_Node : temp) {
                    keys.add(temp_Node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> hm = new MyHashMap<>();
        hm.put("India", 500);
        hm.put("Nepal", 3);
        hm.put("India", 100);
        hm.put("US", 100);
        hm.put("China", 120);


        ArrayList<String> arr_keys = hm.keySet();
        for (String keys : arr_keys) {
            System.out.print(keys + " ");
        }
        System.out.println();
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));

    }
}
