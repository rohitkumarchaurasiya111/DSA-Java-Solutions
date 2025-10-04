package HashMap;

import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> h_set = new HashSet<>();
        h_set.add(5);
        h_set.add(10);
        h_set.add(13);
        h_set.add(15);
        h_set.add(5);

        h_set.remove(5);
        System.out.println(h_set);

        // Iteration on HashSet
        // 1. Using Iterator
        Iterator it = h_set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // 2. Using Enhanced For Loop
        System.out.println("\nEnhaced for Loop is Used: ");
        for (Integer num : h_set) {
            System.out.println(num);
        }
    }
}
