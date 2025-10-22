//Leetcode - 208
//A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

public class Implement_Trie {
    static class Node {
        Node children[] = new Node[26]; // Size is 26, So, that it will contain the space to store all the alphabetes
        boolean endOfWord = false; // End Of word will be true, if it is the last letter of the word

        public Node() {
            for (int i = 0; i < this.children.length; i++) { // In java, There is no need to make all the children's null, it is null by defualt
                this.children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // Root Node -> It is always Empty

    // Function to insert the words into the trie
    // Time Complexity :- O(L) , L = Length of the word with largest size/length
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int indexToSearch = word.charAt(level) - 'a'; // Any Character - 'a' gives it's relative position i.e. index E.g. 'c' - 'a' = 2;
            if (curr.children[indexToSearch] == null) { // If character is not present, then you have to keep the character, If present, change the pointer to next level
                curr.children[indexToSearch] = new Node();
            }
            curr = curr.children[indexToSearch]; // Change the pointer to next level
        }
        curr.endOfWord = true; // the last character of the word is marked as the endOfWord
    }

    // Function to search, if the given word exists in the trie or not
    // Time Complexity = O(Length of the word) = O(n)
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.children[indexToSearch] == null)
                return false; // If the character is not present then return false
            curr = curr.children[indexToSearch]; // if present, go to that character
        }
        return (curr.endOfWord == true) ? true : false; // If the last character of this word is the endOfWord then only this word exist
    }

    // Function to search, if this prefix is present or not, here we don't look for
    // the word on the prefix if it exists or not
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int indexToSearch = prefix.charAt(i) - 'a';
            if (curr.children[indexToSearch] == null)
                return false; // If the character is not present then return false
            curr = curr.children[indexToSearch]; // if present, go to that character
        }
        return true; // If all the characters are present, i.e. prefix is present then return true
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        // Insert all these words into the trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        // Searching a word, if it exists in the trie or not
        System.out.println(search("their"));
        System.out.println(search("thei"));
        // Search Prefix if it exists or not
        System.out.println(startsWith("th"));
    }
}
