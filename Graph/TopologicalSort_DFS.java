import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort_DFS {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // Topological Sort
    // USing DFS
    static void TopologicalSort(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();  //Stack DS is used 

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                TopologicalSortUtil(graph, i, visited, s);
            }
        }

        System.out.println(s);
    }

    static void TopologicalSortUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                TopologicalSortUtil(graph, e.dest, visited, s);
            }
        }
        s.push(curr);  //Stack is used at the last to store the dependencies first as dependencies will be executed first and then it will store the boss i.e. which is not dependent on other and which removing Boss will come first (LIFO)
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;

        // Vertex 1;

        // vertex 2;
        graph[2].add(new Edge(2, 3));

        // Vertex 3;
        graph[3].add(new Edge(3, 1));

        // Vertex 4;
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // Vertex 5;
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        TopologicalSort(graph);

    }
}
