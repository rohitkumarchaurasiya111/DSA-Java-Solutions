package Stack;

import java.util.ArrayList;

public class arraylist_stack {
    static class stack {
        ArrayList<Integer> list = new ArrayList<>();

        void push(int data) {
            list.add(data);
        }

        int pop() {
            int item = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return item;
        }

        int peek() {
            return list.get(list.size() - 1);
        }

        boolean isEmpty() {
            if (list.size() == 0) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());

        }
    }
}
