package Recursion;

public class remove_duplicate_string {
    public static void main(String args[]) {
        String name = "appnacollege";
        StringBuilder sb = new StringBuilder("");
        boolean arr[] = new boolean[26];
        System.out.println(remove_dub(name, 0, sb, arr));
    }

    public static String remove_dub(String name, int i, StringBuilder sb, boolean arr[]) {
        char c = name.charAt(i);
        if (i == name.length() - 1) {
            return sb.toString();
        }
        if (arr[c - 'a']) {
            remove_dub(name, i + 1, sb, arr);
        } else {
            arr[c - 'a'] = true;
            sb.append(c);
            remove_dub(name, i + 1, sb, arr);
        }
        return sb.toString();
    }
}
