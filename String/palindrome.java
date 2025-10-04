package String;

import java.util.Scanner;

public class palindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String word;
        System.out.print("Enter Word to check It is palindrome or not: ");
        word = sc.next();
        System.out.println(palin(word));
        sc.close();
    }

    public static boolean palin(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
