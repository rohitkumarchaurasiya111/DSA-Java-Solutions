package Recursion;

//Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

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
        // If we choose to pair then we have n-2 guys remain to choose their own way and for me i have n-1 choices to pick the guy i want to pair with 
        // Eg:- If total guys are 11 (n) then I have 10 (n-1) guys among which i can choose to pair with and remaining  9 (n-2) guys can choose their own way
        int pair = (n - 1) * pairing(n - 2); // When we choose to pair then we have n-1 choices to pair with and we
                                             // multiply because n-2 strings can pair in different ways and by
                                             // multiplying we get all the ways
        // alone
        int alone = pairing(n - 1); // If we choose to stay single then n-1 friends are remain

        return (pair + alone);
    }
}