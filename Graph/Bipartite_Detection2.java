import java.util.ArrayList;

public class Bipartite_Detection2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
        }
    }

    // Bipartite Detection
    static boolean isBipartite(ArrayList<Edge> graph[]) {

        // If Acyclic then bipartite
        int nodes = isAcyclic(graph);
        // Nodes = 0 means it is an Acyclic GraphS
        if (nodes == 0) {
            return true;
        }
        // If even no of Nodes in a cycle is even then it is Bipartite
        if (nodes % 2 == 0) {
            return true;
        }
        return false;

    }

    static int isAcyclic(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                int nodes = isAcyclicUtil(graph, i, visited, -1);
                if (nodes != 0) {
                    return nodes;
                }
            }
        }
        return 0;
    }

    static int Nodes = 0;

    static int isAcyclicUtil(ArrayList<Edge> graph[], int curr, boolean visited[], int parent) {
        visited[curr] = true;
        Nodes++;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                if (isAcyclicUtil(graph, e.dest, visited, curr) != 0) {
                    return Nodes;
                }
            } else if (visited[e.dest] && e.dest != parent) {
                return Nodes;
            }
        }
        Nodes--;
        return 0;
    }

    public static void main(String[] args) {
        int v = 9;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0;
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // Vertex 1;
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // Vertex 2;
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // Vertex 3;
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 7, 1));

        // Vertex 4;
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // Vertex 5;
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex 6;
        graph[6].add(new Edge(6, 5, 1));

        // Vertex 7;
        graph[7].add(new Edge(7, 3, 1));
        graph[7].add(new Edge(7, 8, 1));

        // Vertex 8;
        graph[8].add(new Edge(8, 7, 1));

        System.out.println("Is Graph Bipartite: " + isBipartite(graph));
    }
}
