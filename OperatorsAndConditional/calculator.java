package OperatorsAndConditional;
import java.util.*;

public class calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Expression in the form of (a operator b):\nOperators are +,-,*,/:");
        int a = scan.nextInt();
        char ope = scan.next().charAt(0);
        int b = scan.nextInt();
        float ans = 0;
        switch (ope) {
            case '+':
                ans = a + b;
                break;
            case '-':
                ans = a - b;
                break;
            case '*':
                ans = a * b;
                break;
            case '/':
                ans = (float) a / b;
                break;
            default:
                System.out.println("Operators Doesnot Match!\nTry Again!");
                System.exit(0);
                break;
        }
        System.out.println("Ans: " + ans);
        scan.close();
    }
}
