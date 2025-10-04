import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKstops {

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

    public static class Pair {
        int node;
        int value;
        int stops;

        public Pair(int n, int v, int s) {
            node = n;
            value = v;
            stops = s;
        }

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int d = flights[i][1];
            int w = flights[i][2];

            graph[s].add(new Edge(s, d, w));
        }

        // Dijkstra's Algorithm with some modifications
        Queue<Pair> pq = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) { // Initializing Destination
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (curr.stops > k) {
                break;
            }

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = curr.node;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] < Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v], curr.stops + 1));
                    }

                }
            }
        }
        return dist[dst];

    }

    public static void main(String[] args) {
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        int n = 4;
        System.out.println(findCheapestPrice(n, flights, src, dest, k));
    }
}
