package HashMap;

import java.util.HashMap;
import java.util.Set;

public class IterateOverHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Nepal", 3);
        hm.put("India", 100);
        hm.put("US", 100);
        hm.put("China", 120);

        System.out.println(hm);

        //This is how we can iterate over HashMap
        Set<String> st = hm.keySet();
        for (String key : st) {
            System.out.print(key + " ");
        }
    }
}
