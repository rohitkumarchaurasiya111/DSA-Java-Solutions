package String;

public class subString {
    public static void main(String args[]) {
        String str = "Rohit is a good boy";
        SubString(str, 0, 7);
        System.out.println(str.substring(0,4));
    }

    public static void SubString(String str, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub += str.charAt(i);
        }

        System.out.println(sub);
    }
}
