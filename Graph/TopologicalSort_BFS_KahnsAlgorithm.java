import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS_KahnsAlgorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void CalculateIndeg(ArrayList<Edge> graph[], int indeg[]) {

        for (int i = 0; i < graph.length; i++) { // Going to the vertex
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // All the edges from the vertex

                indeg[e.dest]++; // Increase the indegree of the node where we reach through i;
            }
        }
    }

    static void TopologicalSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        CalculateIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) { // If a node has Indegree 0
                q.add(i); // Then Add it in the queue
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                indeg[e.dest]--;  //Decrease the indegree of node as we have removed it's parent

                if (indeg[e.dest] == 0) {  //If the indegree of child is 0 then add it to the queue
                    q.add(e.dest);
                }
            }
        }
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
