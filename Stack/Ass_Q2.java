package Stack;
//Simplify Path

// We hava an absolute path for a file (Unix-style), simplify it. Note that absolute path always begin with '/' (root directory), a dot in path represent current directory and double dot represents parent directory.
// Sample Input 1: /apnacollege/
// Sample Output 1:/apnacollege
// Sample Input 1:/a/..
// Sample Output 1:/
import java.util.Stack;

public class Ass_Q2 {
    public static void main(String[] args) {
        simplifyPath("/home/user/Documents/../Pictures");
    }

    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String arr[] = path.split("/");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i].equals("..") && !s.isEmpty()) {
                s.pop();
            } else if (!arr[i].equals(".") && !arr[i].equals("..") && !arr[i].equals("")) {
                s.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder("");
        System.out.println(s);
        for (String i : s) {
            sb.append("/");
            sb.append(i);
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();

    }
}
