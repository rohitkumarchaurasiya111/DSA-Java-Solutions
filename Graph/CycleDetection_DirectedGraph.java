import java.util.ArrayList;

public class CycleDetection_DirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    //Time Complexity = O(V+E)
    //Similar to DFS with some changes to detect cycle

    //Here, We use stack array which stores true for the nodes which are currently at system stack
    static boolean CycleDetection(ArrayList<Edge>[] Graph) {
        boolean visited[] = new boolean[Graph.length];
        boolean stack[] = new boolean[Graph.length];
        for (int i = 0; i < Graph.length; i++) {
            if (!visited[i]) {
                if (CycleDetectionUtil(Graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean CycleDetectionUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //If this is true it means we have gone to curr throught e.dest and agian we can go to e.dest through curr so cycle exist.
            
            if (stack[e.dest]) {
                return true;
            }
            if (!visited[e.dest]) {
                if (CycleDetectionUtil(graph, e.dest, visited, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;
        graph[0].add(new Edge(0, 2));

        // Vertex 1;
        graph[1].add(new Edge(1, 0));

        // vertex 2;
        graph[2].add(new Edge(2, 3));

        // Vertex 3;
        graph[3].add(new Edge(3, 0));

        System.out.println("Cycle Exist: " + CycleDetection(graph));
    }
}
