// Leetcode - 49 : Group Anagram
// Problem Description
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// Examples
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

import java.util.*;

public class Group_Anagram {
    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat", "" };
        groupAnagrams(strs);
    }

    public static void groupAnagrams(String[] strs) {

        // Using Trie Data Structure
        System.out.println("Using Trie: " + groupAnagramTrie(strs));

        // Using HashMap
        System.out.println("Using HashMap: " + groupAnagramsHashMap(strs));
    }

    // Using Trie Data Structure
    public static List<List<String>> groupAnagramTrie(String[] strs) {
        ans = new ArrayList<>();
        // Inserting all the nodes to our trie
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }

        // Iterating throught all the childrens and going to the last node and finding
        // the words to see the anagrams
        triesDFS(root);
        return ans;
    }

    static List<List<String>> ans;

    // Going through all the nodes to reach the end as the end node stores our
    // desired result i.e. list of all the anagram
    public static void triesDFS(Node root) {
        if (root == null)
            return;
        if (root.endOfWord) { // if we have reached the end of word then store it in the result
            ans.add(root.words);
        }
        for (int i = 0; i < root.children.length; i++) { // loop thorugh all the childrens of the node
            if (root.children[i] != null) { // if childrens node has some values
                triesDFS(root.children[i]); // Go to the children node
            }
        }
    }

    // This insert function will insert all these words to the trie (but flipping
    // their characters, their characters will be inserted in asecending orderes)
    // and at each node, it also stores the word whose part is that node. So, at the
    // end of the word i.e. last node, it will always contain the anagrams.
    public static void insert(String word) {
        char alphabetes[] = word.toCharArray(); // Getting all the characters of the word
        Arrays.sort(alphabetes); // Sorting all the characters of the word in alphabetical order

        Node curr = root;
        // Now we will insert these alphabetes
        for (int i = 0; i < alphabetes.length; i++) {
            int indexToSearch = alphabetes[i] - 'a';
            if (curr.children[indexToSearch] == null) {
                curr.children[indexToSearch] = new Node();
            }
            curr = curr.children[indexToSearch];
        }
        curr.words.add(word); // Insert the word at the last node
        curr.endOfWord = true;
    }

    public static Node root = new Node();

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord;
        ArrayList<String> words = new ArrayList<>();
    }

    // Using HashMap
    // Time Complexity: O(N.K.LogK)
    public static List<List<String>> groupAnagramsHashMap(String[] strs) {

        HashMap<String, ArrayList<String>> hm = new HashMap<>(); // To store the key (word made by characters in
                                                                 // alphabetical order) and value (List of all anagrams
                                                                 // of key)

        for (int i = 0; i < strs.length; i++) { // iterating through all the words
            String word = strs[i];
            char alphabetes[] = word.toCharArray(); // Getting all the characters of the word
            Arrays.sort(alphabetes); // Sorting all the characters of the word in alphabetical order

            // Converting this into word
            String newWord = new String(alphabetes); // Making a new word where all the characters are in shorted order

            if (hm.containsKey(newWord)) { // Checking if our map already contains this word or not
                // if map already contains this word then
                // Add this word to the list of values as this is also an anagram of key
                ArrayList<String> anagrams = hm.get(newWord);
                anagrams.add(word);
            } else { // if our map doesnot conatins this word
                // Create a key value pair of this word and add into the HashMap
                ArrayList<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                hm.put(newWord, anagrams); // adding this newWord as the key with value as List of word
            }
        }

        return new ArrayList<>(hm.values()); // Returning the values stored in the HashMap
    }
}
