package String;

public class ChangeTOupperCase {
    public static void main(String args[]) {
        String sh = "hello, i am rohit ";
        uppercase(sh);
    }

    public static void uppercase(String sh) {
        StringBuilder new_sh = new StringBuilder("");
        // char ch = ' ';
        // for (int i = 0; i < sh.length(); i++) {

        // if (ch == ' ') {
        // ch = sh.charAt(i);
        // new_sh.append(Character.toUpperCase(ch));
        // } else {
        // ch = sh.charAt(i);
        // new_sh.append(ch);
        // }

        // }
        new_sh.append(Character.toUpperCase(sh.charAt(0)));
        for (int i = 1; i < sh.length(); i++) {
            char ch = sh.charAt(i);
            if (ch == ' ' && i < sh.length() - 1) {
                new_sh.append(ch);
                i++;
                // if (i < sh.length()) {
                new_sh.append(Character.toUpperCase(sh.charAt(i)));
                // }
            } else {
                new_sh.append(ch);
            }
        }
        System.out.println(new_sh);
    }
}
