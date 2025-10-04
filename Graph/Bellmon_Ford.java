import java.util.ArrayList;

public class Bellmon_Ford {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    // Total T.C = O(E*V);
    static void bellmonFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // To store the distance from to source to each vertices

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // Initializing all other nodes to infinity except the src as it is
                                             // initialized to 0
            }
        }

        // BellMon Ford's Algorithm Starts Here.

        int vertices = graph.length;

        // Total T.C = O(E*V);
        // T.c = o(V)
        for (int k = 0; k < vertices - 1; k++) {

            // T.C = o(E)
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation
                    if (dist[u] < Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Printing the result
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Vertex 1;
        graph[1].add(new Edge(1, 2, -4));

        // Vertex 2;
        graph[2].add(new Edge(2, 3, 2));

        // Vertex 3;
        graph[3].add(new Edge(3, 4, 4));

        // Vertex 4;
        graph[4].add(new Edge(4, 1, -1));

        bellmonFord(graph, 0);
    }
}
