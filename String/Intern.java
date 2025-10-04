package String;
import java.util.Scanner;
public class Intern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // String st2 = new String("Hi, It's Rohit").intern();
        // String st1 = new String("Hi, It's Rohit").intern()
    
        String st1 = sc.nextLine().intern();
        String st2 = sc.nextLine().intern();

        if (st1 == st2) {
            System.out.println("Wow, Both are same");
        }
        sc.close();
    }
}
