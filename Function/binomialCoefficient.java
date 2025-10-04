package Function;

public class binomialCoefficient {
    public static int factorial(int num) {
        int fact = 1;
        while (num > 0) {
            fact *= num;
            num--;
        }
        return fact;
    }

    public static int binCoeff(int n, int r) {

        int coeff = factorial(n) / (factorial(r) * factorial(n - r));
        return coeff;
    }

    public static void main(String args[]) {
        int n = 5;
        int r = 2;
        int coeff = binCoeff(n, r);
        System.out.println(coeff);
    }
}
