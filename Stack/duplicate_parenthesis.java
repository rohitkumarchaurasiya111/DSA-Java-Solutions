package Stack;

import java.util.Stack;

public class duplicate_parenthesis {
    public static void main(String[] args) {
        System.out.println(duplicate_parenthesis_exist("((a+b)+(c))"));
    }

    public static boolean duplicate_parenthesis_exist(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (c == ')') {
                if (s.peek() == '(') {  //If the top element is ( then it means () is duplicate
                    return true;
                }
                while (s.peek() != '(') {  //pop all expression until we find (
                    s.pop();
                }
                s.pop(); //Once we find (, pop it as well
            } else {
                s.push(c); //If c !=  ) then push every other character in stack 
            }
        }
        return false; //If () is not duplicate then false;
    }
}
