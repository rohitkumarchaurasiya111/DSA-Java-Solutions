package HashMap;
//Sort by Frequency

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string. Return the sorted string. If there are multiple answers, return any of them.
// Sample Input 1: s = "cccaaa"
// Sample Output 1: "aaaccc"

public class SortByFrequency {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // Now, All values are kept in the hashMap. Once the values are kept on the
        // HashMap. We not use PrioirtyQueue so that the characters with highest vlaue
        // will come first

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        //(a, b) -> b.getValue() - a.getValue() --- THis lambda expression is used  to define the order in which the elements will be prioritized (higher priority comes first). since b-a means priority in descending order.
        for (Map.Entry<Character, Integer> Pair_of_char_and_value : hm.entrySet()) {
            pq.add(Pair_of_char_and_value);
        }

        // To form the string from PQ;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll().getKey();
            int freq = hm.get(c);
            while (freq != 0) {
                sb.append(c);
                freq--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
