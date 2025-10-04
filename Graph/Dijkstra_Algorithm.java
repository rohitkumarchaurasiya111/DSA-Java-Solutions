import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {

    // Dijkstra's Algorithm
    // Shortest paths from the source to all vertices (weighted graph)

    // BFS and Greedy Algorithm and Prioirty Queue concepts are used here

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

    // This Pair class is used in PQ to give the shortest distance Node first
    // (Greedy Approach)
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            node = n;
            dist = d;
        }

        public int compareTo(Pair obj) {
            return this.dist - obj.dist;
        }
    }


    //T.C = O(V + E.LogV)
    
    static void Dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // This will store the distance from src to node; E.g.:- dist[5] = distance
                                            // from source to Node 5

        // First initialize the distance as Infinity except the distance of src as it is
        // 0;
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Priority Queue is made instead of Normal Queue (used in BFS) as PQ will give
        // the values on the basis of shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // Visited is used to track if this is visited or not
        boolean visited[] = new boolean[graph.length];

        // As done in BFS Algorithm
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    // Relaxation is used to calculate the shortest distance
                    int u = curr.node;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;

                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Printing the array to see the distance
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Vertex 1;
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // Vertex 2;
        graph[2].add(new Edge(2, 4, 3));

        // Vertex 3;
        graph[3].add(new Edge(3, 5, 1));

        // Vertex 4;
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // Vertex 5;

        Dijkstra(graph, 0);

    }
}
