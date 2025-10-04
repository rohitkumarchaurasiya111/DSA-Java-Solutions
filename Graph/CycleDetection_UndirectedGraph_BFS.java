import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
//Detect cycle in an undirected graph using BFS
// We have an an undirected graph, how to check if there is a cycle in the graph? For example, the following graph has a cycle 1-0-2-1..
import java.util.Queue;

public class CycleDetection_UndirectedGraph_BFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length]; // To check if a node is visited or not
        int parent[] = new int[graph.length]; // To store the parent of a node
        Arrays.fill(parent, -1); // Initialize parent array with -1

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (!visited[e.dest]) {
                        parent[e.dest] = curr;
                        q.add(e.dest);
                    } else if (e.dest != parent[curr]) { // If the node which is neighbour is not your parents then but
                                                         // also it is visited
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

        System.out.println("Cycle Detected: " + detectCycle(graph));

    }
}
