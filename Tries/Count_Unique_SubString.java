//Leetcode 1698 - Number of Distinct Substrings in a String

//Count of distinct substrings of a string using Suffix Trie
// Given a string of length n of lowercase alphabet characters, we need to count total number of distinct substrings of this string.
// str = "ababa"
// ans = 10
// Total number of distinct substring are 10, which are, "", "a", "b", "ab", "ba", "aba", "bab", "abab", "baba" and "ababa"

//We can solve this question using Trie Data Structure in O(n) time complexity

import java.util.*;

public class Count_Unique_SubString {
    public static void main(String[] args) {
        String st = "ababa";

        // Using Trie Data Structure
        System.out.println("Using Trie: No. of Distince Substring is: " + countDistinctSubstring(st));

        // Using HashSet
        countDistinctSubstringUsingHashSet(st);
    }

    // We can solve this question using hashSet but this will take O(n^2) time
    // complexity which is more
    public static void countDistinctSubstringUsingHashSet(String st) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < st.length(); i++) { // This will generate all the substring possible
            for (int j = i + 1; j <= st.length(); j++) {
                hs.add(st.substring(i, j)); // Hashset will store only the unique substrings
            }
        }
        System.out.println("Using Hashset: Unique Substring possible = " + (hs.size() + 1)); // adding 1 for empty
                                                                                             // string
    }

    // Using Trie Data Structure to solve this question
    // Substring = all prefixes of all suffix of a string || all suffixes of all
    // prefixes of a string
    // and all unique substrings = all unique prefixes of all suffix of a string and
    // we know that trie always store unique prefixes of a word.
    // So, here if we insert all the suffixes of a string into trie then all the
    // prefixes inserted will be unique and the no. of nodes that are made will be
    // the no. of substrings possible
    public static int countDistinctSubstring(String st) {
        root = new Node();
        noOfNodesPresent = 0;

        for (int i = 0; i < st.length(); i++) {
            insert(st.substring(i, st.length())); // this will give all the possible suffix of a given string and if it
                                                  // is inserted into the trie data structure, it will store the unique
                                                  // prefixes only, In this way -> the no. of nodes = no. of unique
                                                  // substring.
        }
        return noOfNodesPresent + 1; // adding 1 as we will include the "" (empty string) also as a substring
    }

    static class Node {
        Node childrens[] = new Node[26];
        boolean endOfString = false;
    }

    static Node root;
    static int noOfNodesPresent;

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.childrens[indexToSearch] == null) {
                curr.childrens[indexToSearch] = new Node();
                noOfNodesPresent++;
            }
            curr = curr.childrens[indexToSearch];
        }
        curr.endOfString = true;
    }
}
