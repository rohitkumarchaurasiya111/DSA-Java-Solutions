package String;

public class Lexicographic_Order {
    public static void main(String args[]) {
        String fruits[] = { "apple", "mango", "banana" };
        int max = 0;
        for (int i = 0; i < fruits.length - 1; i++) {
            int compare = fruits[i].compareToIgnoreCase(fruits[i + 1]);
            if (compare > 0) {
                max = i;
            }
        }
        System.out.println(fruits[max]);

    }
}
