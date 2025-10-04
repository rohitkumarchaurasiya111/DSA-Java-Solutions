package Queue;

import java.util.Queue;
import java.util.LinkedList;

public class firstNonRepetingLetter {
    public static void main(String[] args) {
        Find_first_Non_repeting_character("aabccxb");
    }

    static void Find_first_Non_repeting_character(String s) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty()) {
                if (freq[q.peek() - 'a'] >= 2) {
                    q.remove();
                } else {
                    break;
                }
            }
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
}
