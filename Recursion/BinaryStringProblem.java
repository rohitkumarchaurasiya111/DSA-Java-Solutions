package Recursion;

public class BinaryStringProblem {
    public static void main(String args[]) {
        int n = 3;
        String sb = new String("");
        print(n, 0, sb);
    }

    static void print(int n, int LastVisit, String str) {

        // if (LastVisit == 1) {
        // str.append(0);
        // print(n - 1, 0, str);
        // } else {
        // str.append(0);
        // print(n - 1, 0, str);
        // str.append(1);
        // print(n - 1, 1, str);
        // }

        // Here, we are not using binary strings because once the stirng is appended
        // here then we will also have to remove the last one for other step

        if (n == 0) {
            System.out.println(str);
            return;
        }
        print(n - 1, 0, str + "0");

        if (LastVisit == 0) {
            print(n - 1, 1, str + "1");
        }

    }
}