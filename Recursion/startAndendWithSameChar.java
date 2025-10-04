package Recursion;

//WearegivenastringS,weneedtofindthecountofallcontiguoussubstringsstarting and ending with the same character.
public class startAndendWithSameChar {
    public static void main(String args[]) {
        String str = "abcab";
        System.out.println(countOfSubStr(str, 0, 0, 0));
    }

    public static int countOfSubStr(String str, int i, int j, int count) {
        if (i >= str.length() || j >= str.length()) {
            return count;
        }
        if (str.charAt(i) == str.charAt(j)) {
            count++;
        }
        countOfSubStr(str, i, j + 1, count);
        countOfSubStr(str, i++, j, count);
        return count;
    }
}
