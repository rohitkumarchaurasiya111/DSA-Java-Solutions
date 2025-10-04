package Function;

public class prime {
    public static boolean Isprime(int num) {
        // corner case
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeRange(int num) {
        for (int i = 2; i <= num; i++) {
            if (Isprime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String args[]) {
        // System.out.println(Isprime(2));
        primeRange(10);
    }
}
