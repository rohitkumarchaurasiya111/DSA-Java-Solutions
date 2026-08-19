package Recursion;

public class FriendPairingProblem {
    public static void main(String args[]) {
        int n = 3;
        System.out.println(pairing(n));
    }

    public static int pairing(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // Pairing
        int pair = (n - 1) * pairing(n - 2); // When we choose to pair then we have n-1 choices to pair with and we
                                             // multiply because n-2 strings can pair in different ways and by
                                             // multiplying we get all the ways
        // alone
        int alone = pairing(n - 1);

        return (pair + alone);
    }
}