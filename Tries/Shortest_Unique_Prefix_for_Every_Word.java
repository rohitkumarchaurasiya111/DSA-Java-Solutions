//Shortest Unique prefix for every word
//Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.
// Input:
// N = 4
// arr[] = {"zebra", "dog", "duck", "dove"}
// Output: z dog du dov

// We can use Trie Data Structure Here

public class Shortest_Unique_Prefix_for_Every_Word {
    public static void main(String[] args) {
        int N = 10;
        String arr[] = { "zzmn", "vib", "tcady", "jjfl", "ire", "taf", "hknha", "hmwm", "sasae", "stx" };

        // Printing the Result
        System.out.print("Minimum Prefixes are: ");
        for (String value : findPrefixes(arr, N)) {
            System.out.print(value + " ");
        }
    }

    static String[] findPrefixes(String[] arr, int N) {
        root = new Node(); // Since, root is static. So, for new input we will reset it's value. So that
                           // it's old value will not make any trouble
        for (int i = 0; i < arr.length; i++) { // Inserting all the words in our Trie
            insert(arr[i]);
        }

        // For each words finding the minimum prefix
        String result[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            Node curr = root;
            for (int j = 0; j < word.length(); j++) {
                int indexToSearch = word.charAt(j) - 'a';
                if (curr.childrens[indexToSearch].frequency == 1) { // This is the last character of my prefix with
                                                                    // minimum length
                    result[i] = word.substring(0, j + 1);
                    break; // Break the first time, whenever you get the frequecy 1
                }
                curr = curr.childrens[indexToSearch]; // if frequency not equals to 1 move to next node
            }
        }
        return result;
    }

    // Implementing Trie Data Structure
    static class Node {
        Node childrens[] = new Node[26]; // Size = 26, So, that all the alphabetes can be stored here
        boolean endOfWord = false;
        int frequency = 1; // An extra variable, to store how many times a specific character is been used
                           // to form a word
    }

    static Node root = new Node(); // Root node is always Null

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.childrens[indexToSearch] == null) { // if character doesnot already exist then create
                curr.childrens[indexToSearch] = new Node();
            } else { // if character already exist increase frequecy
                curr.childrens[indexToSearch].frequency++;
            }
            curr = curr.childrens[indexToSearch];
        }
        curr.endOfWord = true;
    }
}
