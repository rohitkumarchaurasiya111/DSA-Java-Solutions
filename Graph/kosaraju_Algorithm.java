
//Using Kosaraju's Algorithm to print, Strongly Connected Components:
// Steps
// a. Get nodes in stack (topological sort)
// b. Transpose the graph
// c. Do DFS according to stack nodes on the transpose graph

// It helps us to get the Strongly Connected Components 
import java.util.ArrayList;
import java.util.Stack;

public class kosaraju_Algorithm {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        kosarajuAlgorithm(graph);

    }

    public static void kosarajuAlgorithm(ArrayList<Edge> graph[]){
        //Step 1 - Get nodes in Topological Order
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {  //This will ensure that all nodes are visited
            if(!visited[i]) dfsTopologicalOrder(graph, stack, i, visited);
        }

        //Step 2 - Transpose the graph
        ArrayList<Edge> transposedGraph[] = new ArrayList[graph.length];
        for (int i = 0; i < transposedGraph.length; i++) {
            visited[i] = false;
            transposedGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge currEdge = graph[i].get(j);
                transposedGraph[currEdge.dest].add(new Edge(currEdge.dest, currEdge.src));
            }
        }

        //Step 3 - DFS using stack nodes on the transposedGraph
        while (!stack.isEmpty()) {
            int curr=stack.pop();
            if(!visited[curr]){
                System.out.print("SCC -> ");
                dfsUtil(transposedGraph, curr, visited);
                System.err.println();
            } 
        }

    }
    //Gives the nodes in topological Order
    public static void dfsTopologicalOrder(ArrayList<Edge> graph[], Stack<Integer> stack, int curr, boolean visited[]){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge currEdge = graph[curr].get(i);
            if(!visited[currEdge.dest])
                dfsTopologicalOrder(graph, stack, currEdge.dest, visited);
        }
        stack.push(curr);
    }
    //Does the DFS On the Nodes 
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]){
        visited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge currEdge = graph[curr].get(i);
            if(!visited[currEdge.dest])
                dfsUtil(graph, currEdge.dest, visited);
        }
    }
}
