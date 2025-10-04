import java.util.ArrayList;

public class CycleDetection_UndirectedGraph_DFS {

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

    // Cycle Detection in a Graph
    // Time Complexity - O(V+E) -> similar to DFS as we have the code very similar
    // to DFS
    static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                if (detectCycleutil(graph, i, vis, -1)) {
                    return true;
                }
        }
        return false;
    }

    static boolean detectCycleutil(ArrayList<Edge>[] graph, int current, boolean vis[], int parent) {
        vis[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (!vis[e.dest]) { // Not visited Node
                if (detectCycleutil(graph, e.dest, vis, current)) {
                    return true;
                }
            } else if (vis[e.dest] && e.dest != parent) {
                return true;
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

        System.out.println(detectCycle(graph));

    }
}
