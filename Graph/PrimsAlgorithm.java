import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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

    static class Pair implements Comparable<Pair> {
        int vertex;
        int value;

        public Pair(int v, int val) {
            vertex = v;
            value = val;
        }

        public int compareTo(Pair obj) {
            return this.value - obj.value;
        }
    }

    static void PrmisAlgo(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        ArrayList<Edge> ans[] = new ArrayList[graph.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new ArrayList<>();
        }

        pq.add(new Pair(0, 0));
        int cost = 0;
        int parent = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();

            if (!visited[p.vertex]) {
                visited[p.vertex] = true;
                ans[parent].add(new Edge(parent, p.vertex, p.value));
                cost += p.value;
                for (int i = 0; i < graph[p.vertex].size(); i++) {
                    Edge e = graph[p.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
            parent = p.vertex;
        }

        System.out.println(cost);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].size(); j++) {
                Edge temp = ans[i].get(j);
                System.out.println(temp.src + " " + temp.dest + " " + temp.wt);
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // Vertex 0;
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // Vertex 0;
        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));

        // Vertex 0;
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 0, 30));

        PrmisAlgo(graph);
    }
}