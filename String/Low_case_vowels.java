package String;

// Count how many times lower case vowel s occurred in a String entered by the user
import java.util.Scanner;

public class Low_case_vowels {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(CheckVowel(str));
        sc.close();
    }

    public static int CheckVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
