package Recursion;

// You are given a number (eg -  2019), convert it into a String of english like“two zero one nine”.  Use a recursive function to solve this problem
public class ConvertToWord {
    // public static void main(String args[]) {
    // int num = 2013;
    // StringBuilder sb = new StringBuilder();
    // Word(num, sb);
    // System.out.println(sb);
    // }

    // static void Word(int num, StringBuilder sb) {
    // if (num <= 0) {
    // return;
    // }
    // Word(num / 10, sb);
    // int ch = num % 10;

    // switch (ch) {
    // case 0:
    // sb.append("zero ");
    // break;
    // case 1:
    // sb.append("one ");
    // break;
    // case 2:
    // sb.append("two ");
    // break;
    // case 3:
    // sb.append("three ");
    // break;
    // case 4:
    // sb.append("four ");
    // break;
    // case 5:
    // sb.append("five ");
    // break;
    // case 6:
    // sb.append("six ");
    // break;
    // case 7:
    // sb.append("seven ");
    // break;
    // case 8:
    // sb.append("eight ");
    // break;
    // case 9:
    // sb.append("nine ");
    // break;
    // default:
    // break;
    // }
    // }

    // We can also do like this as well
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten" };

    static void Word(int num) {
        if (num <= 0) {
            return;
        }
        int lastNum = num % 10;
        Word(num / 10);
        System.out.print(digits[lastNum] + " ");
    }

    public static void main(String args[]) {
        Word(1230);
    }
}
