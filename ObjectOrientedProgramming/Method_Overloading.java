package ObjectOrientedProgramming;

public class Method_Overloading {
    public static void main(String args[]) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(2, 3));
        System.out.println(calc.sum(2.3f, 3.7f));
        System.out.println(calc.sum(2, 3, 1));
    }
}

class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}