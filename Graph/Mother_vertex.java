//Given a directed graph, find a mother vertex in the graph (if it exists).
//A mother vertex is a vertex v such that every other vertex in the graph is reachable from v.

//We can solve this using DFS normally, but here the time complexity will be more 
//So, Here we will have to use Kosaraju's Algorithm
//We will make an array visited[]
//Let's start visiting a vertex, if it is connected to mother vertex then we won, if not we will see only those vertex which are not yet visited, because not visited vertices can be the mother vertex.

import java.util.ArrayList;

public class Mother_vertex {
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V]; //To keep the track which nodes are yet to be visited
        int motherVertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                dfsUtil(adj, visited, i);
                motherVertex = i;
            }
        }
        //Checking if our predicted motherVertex is correct or not 
        visited = new boolean[V];
        dfsUtil(adj, visited, motherVertex);
        for (boolean b : visited) {
            if(!b) return -1;
        }
        return motherVertex;
    }
    public static void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean visited[], int curr){
        visited[curr] = true;
        for(int i=0; i<adj.get(curr).size(); i++){
            int next = adj.get(curr).get(i);
            if(!visited[next])
                dfsUtil(adj, visited, next);
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices (0 to 4)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(1).add(0);  // 1 -> 0
        adj.get(0).add(2);  // 0 -> 2
        adj.get(2).add(1);  // 2 -> 1
        adj.get(0).add(3);  // 0 -> 3
        adj.get(3).add(4);  // 3 -> 4

        System.out.println(findMotherVertex(V, adj));
    }

}
