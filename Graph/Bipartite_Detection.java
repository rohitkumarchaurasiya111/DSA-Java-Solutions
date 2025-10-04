import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Detection {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Here, We are using the BFS to find if the graph is Bipartite or not

    // Here, we have not used the array Visited because the array Color does our
    // work for visited as well

    // Time Complexity - O(V+E)
    static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                if (!isBipartiteUtil(graph, color, q)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBipartiteUtil(ArrayList<Edge> graph[], int color[], Queue<Integer> q) {

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);

                if (color[e.dest] == -1) {
                    q.add(e.dest);
                    int newColor = (color[curr] == 0) ? 1 : 0;
                    color[e.dest] = newColor;
                } else if (color[e.dest] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

        System.out.println("Graph is Bipartite - " + isBipartite(graph));

    }
}
