// Leetcode 720: Longest Word in a Dictionary

// Longest Word with all Prefixes
// Find the longest string in words such that every prefix of it is also in words.
// words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// ans = "apple"

public class Longest_Word_with_All_Prefixes {
    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        longestWord(words);
    }

    public static void longestWord(String[] words) {
        root = new Node();
        // Insert all the words in our Trie DS
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Using Loop and going to each words given and seeing if it is the answer or
        // not
        System.out.println("Using Loop and Going throught all the words: " + longestWordLoop(words));

        // Using Recursion -> We start from root node and move to the next node using
        // recursion if it satisfies our condition
        longestWordRecursion(root, new StringBuilder(""));
        System.out.println("using Recursion : " + ans);
    }

    // Here, we are going to all the words and then looking looking if this words is
    // our target or not
    public static String longestWordLoop(String words[]) {
        // Finding the longest word will all the prefixes
        // If their exist a word whose all the prefixes are also a word in dictionary,
        // then for all it's node in trie, the value of node will be the endofword
        String longestWordWithAllPrefixes = "";
        for (int i = 0; i < words.length; i++) { // Iterating through all the words
            String word = words[i];
            Node curr = root;
            boolean isThisLongestWordWithAllPrefixes = true;
            for (int j = 0; j < word.length(); j++) { // Iterating through all the characters of the word
                int indexToSearch = word.charAt(j) - 'a';
                if (!(curr.childrens[indexToSearch] != null && curr.childrens[indexToSearch].endOfWord)) { // if it's
                                                                                                           // character
                                                                                                           // is not
                                                                                                           // null and
                                                                                                           // it is the
                                                                                                           // endofword
                                                                                                           // then only
                                                                                                           // it can be
                                                                                                           // our
                                                                                                           // desired
                                                                                                           // targetted
                                                                                                           // word
                    isThisLongestWordWithAllPrefixes = false;
                    break; // if this character is not my desired one then there is no need to see other
                           // characters in this node
                }
                curr = curr.childrens[indexToSearch]; // point to next character to see our condition to next character
            }
            if (isThisLongestWordWithAllPrefixes) { // if it passes our criteria then we see if it is larger than our
                                                    // previous result
                if (word.length() > longestWordWithAllPrefixes.length()) {
                    longestWordWithAllPrefixes = word; // if it is larger then store this
                } else if (word.length() == longestWordWithAllPrefixes.length()) { // if it is of same size
                    if (word.compareTo(longestWordWithAllPrefixes) < 0) { // store those whose which is lexogrametically
                                                                          // smaller
                        longestWordWithAllPrefixes = word;
                    }
                }
            }
        }
        return longestWordWithAllPrefixes;
    }

    // Using recursion -> From the node, going to all the deeper lever if it
    // satisfies our condition and finding the longest answer
    static String ans = "";

    public static void longestWordRecursion(Node root, StringBuilder temp) {
        if (root == null)
            return;

        for (int i = 0; i < root.childrens.length; i++) { // To iterate throught all the childrens of the node
            if (root.childrens[i] != null && root.childrens[i].endOfWord) { // If it follows our condition i.e. if it's
                                                                            // character is not null and it is the
                                                                            // endofword then only it can be our desired
                                                                            // targetted word
                char ch = (char) (i + 'a'); // Get that character which follows our condition and store it into our temp
                                            // variable
                temp.append(ch);
                if (temp.length() > ans.length()) { // If temp variable is bigger than the answer then store temp in ans
                    ans = temp.toString();
                }
                longestWordRecursion(root.childrens[i], temp); // Call for it's childrens to find the longest word with
                                                               // all prefixes
                // Backtracking -> we have to remove our old kept character
                temp.deleteCharAt(temp.length() - 1); // After calls are made and returned, while bactracking remove the
                                                      // character which is appended. So that we can explore other
                                                      // possibilities.
            }
        }
    }

    // Implementing Trie Data Structure
    static class Node {
        Node childrens[] = new Node[26]; // Size = 26, So, that all the alphabetes can be stored here
        boolean endOfWord = false;
    }

    static Node root = new Node(); // Root node is always Null

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.childrens[indexToSearch] == null) { // if character doesnot already exist then create
                curr.childrens[indexToSearch] = new Node();
            }
            curr = curr.childrens[indexToSearch];
        }
        curr.endOfWord = true;
    }
}
