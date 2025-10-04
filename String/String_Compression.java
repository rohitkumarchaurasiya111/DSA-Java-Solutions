package String;

public class String_Compression {
    public static void main(String args[]) {
        String str = "aaabbcccdd";
        CompressString(str);
    }

    public static void CompressString(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            int count = 1;

            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            char ch = str.charAt(i);
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }
        }
        System.out.println(sb);
    }
}
