// Leetcode - 139 : Word Break
// Given an input string and a dictionary of words, find out if the input string can be broken into a space-separated sequence of dictionary words.
// words[] = { i, like, sam, samsung, mobile, ice)
// key = "ilikesamsung"
// output: true

//Trie Data Structure is used to solve this problem

import java.util.*;

public class Word_Break_Problem {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
                "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        // List<String> wordDict = new ArrayList<>(Arrays.asList("i", "like", "sam",
        // "samsung", "mobile", "ice"));
        // String s = "ilikesamsung";
        Word_Break_Problem obj = new Word_Break_Problem();
        System.out.println(obj.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // First make a trie data Structure using these words
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }

        // Looking if our trie contains the given string or not
        // Using Trip and DP
        return wordBreakUsingDP(s);

        // Using Trie and Recursion
        // return wordBreakRecursion(s);
    }

    // Using DP
    public boolean wordBreakUsingDP(String s) {
        boolean dp[] = new boolean[s.length() + 1]; // if dp at specific point is true, it means this point is the
                                                    // starting of the new word
        dp[0] = true; // initialization

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == false)
                continue; // If dp[i] is false, it means, it is not the starting point of a word in our
                          // Trie. So, there is no need to search for this in our Trie

            // If point i is the starting point of the word then we will search for other
            // starting point of other word after this word ends
            for (int j = i + 1; j < dp.length; j++) { // i represent startin point of string and j represent the ending
                                                      // point
                if (search(s.substring(i, j))) { // i is inclusive and j is exclusive.
                    dp[j] = true; // It means this might be the starting point of the new word in our Trie
                }
            }
        }
        return dp[s.length()]; // If last point is mark the starting i.e. true it means we have iterated
                               // throught all the characters. else if it is false, it means we were not able
                               // to iterate throught all the characters
    }

    // This code is correct, but it takes a lot of time for some inputs like:
    // wordDict =
    // ("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
    // String =
    // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    public boolean wordBreakRecursion(String s) {
        // Base Case
        if (s.length() == 0)
            return true; // If string is "" then return true

        // For the String give, we will check all the occurence if it exists or not
        for (int i = 1; i <= s.length(); i++) {
            if (search(s.substring(0, i)) && wordBreakRecursion(s.substring(i))) { // If first part is present then we
                                                                                   // call this recursive function to
                                                                                   // check that the remaining part is
                                                                                   // present or not
                return true;
            }
        }
        return false;
    }

    class Node {
        Node childrens[] = new Node[26]; // side = 26, So, that it can contain all the neighbours
        boolean endOfWord = false; // It will be true, if it is the last letter of the word
    }

    Node root = new Node();

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.childrens[indexToSearch] == null) { // If character doesnot exist already then make it
                curr.childrens[indexToSearch] = new Node();
            }
            curr = curr.childrens[indexToSearch]; // curr will point to new deeper level
        }
        curr.endOfWord = true; // Mark true as it is the end of the word
    }

    boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indexToSearch = word.charAt(i) - 'a';
            if (curr.childrens[indexToSearch] == null) { // If character doesnot exist already then return false;
                return false;
            }
            curr = curr.childrens[indexToSearch]; // curr will point to new deeper level
        }
        return (curr.endOfWord == true); // Return true, if this character is the end of the word
    }
}
