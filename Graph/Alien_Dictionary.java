import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Here, We are using Array of size 26 as we know alien dictionary can contains lower alphabets only
//We could have also used HashMap<Character, List<Characters>> as graph and Map<Character, Integer> for InOrder.

//We have to use Topological Sorting using Kahn's Algorithm to solve this problem
public class Alien_Dictionary {
    public static void main(String[] args) {
        // String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        String[] words = {"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        //String[] words = {"abc","ab"};
        String order = findOrder(words);
        System.out.println("Order: " + order);
    }

    //Represents Edge between two nodes
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static String findOrder(String[] words) {
        int noOfCharacters = 26; //Lower case characters are 26
        ArrayList<Edge> graph[] = new ArrayList[noOfCharacters];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //Creating Graph using words in Alien Dictionary
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            //Invalid Case, like (abc , ab)
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)){
                    int position1 = word1.charAt(j) - 'a';
                    int position2 = word2.charAt(j) - 'a';
                    graph[position1].add(new Edge(position1, position2));
                    break;
                }
            }
        }

        //Array to keep track of used characters, So, We can use later
        boolean usedCharacters[] = new boolean[noOfCharacters];
        int usedCharactersCount = 0;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if(!usedCharacters[c-'a']) {
                    usedCharacters[c-'a'] = true;
                    usedCharactersCount++;
                }
            }
        }

        //Topological Soritng, Using Kahn's Algorithm to see if Loop exists in graph
        // 1. Calculating InDegree
        int InDegree[] = new int[noOfCharacters];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge currEdge = graph[i].get(j);
                InDegree[currEdge.dest]++;
            }
        }

        // Keeping the used characters only with InDegree 0 into the Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < InDegree.length; i++) {
            if(InDegree[i] == 0 && usedCharacters[i]) q.add(i);
        }

        String answer = "";
        while (!q.isEmpty()) {   //We only get used Characters in queue.
            int currNode = q.remove();
            answer +=(char) (currNode+ 'a');
            for (int i = 0; i < graph[currNode].size(); i++) {
                Edge currEdge = graph[currNode].get(i);
                InDegree[currEdge.dest]--;
                if(InDegree[currEdge.dest] == 0){
                    q.add(currEdge.dest);
                }
            }
        }

        //If loop exists, then answer would have less character than total used characters count as inDegree of that character which forms loop will not be 0,
        if(answer.length() != usedCharactersCount) return "";
        return answer;
    }
}
