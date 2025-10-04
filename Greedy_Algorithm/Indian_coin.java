package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

//Indian Coins
// We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000]. Find min no. of coins/notes to make change for a value V.
// V = 121
// ans = 3 (100+20+1)
// V = 590
// ans = 4 (500+50+20+20)

public class Indian_coin {
    public static void main(String[] args) {
        Integer money[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(money, Comparator.reverseOrder());
        int change = 590;
        int num = no_of_notes(money, change);
        System.out.println(num);
    }

    static int no_of_notes(Integer money[], Integer change) {

        int counter = 0;

        for (int i = 0; i < money.length;) {
            if (change >= money[i]) {
                change = change - money[i];
                counter++;
            } else {
                i++;
            }
        }
        return counter;
    }
}
