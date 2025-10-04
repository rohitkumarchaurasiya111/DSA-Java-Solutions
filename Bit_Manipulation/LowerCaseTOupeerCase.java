package Bit_Manipulation;

//Convert uppercase characters to lowercase using bits
public class LowerCaseTOupeerCase {
    public static void main(String args[]) {
        char ch = 'J';
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println((char) (ch | ' '));
        }

    }
}
