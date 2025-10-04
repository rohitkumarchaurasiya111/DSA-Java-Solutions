import java.util.ArrayList;

public class AllPathsFromSrc_Dest {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // All Paths from Source to Destion
    // DFS is used
    // T.C = O(V^V); -> More Time Complexity 
    
    static void Allpaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + src);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            Allpaths(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Vertex 0;
        graph[0].add(new Edge(0, 3));

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

        Allpaths(graph, 5, 1, "");

    }
}
