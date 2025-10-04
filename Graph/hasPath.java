//We are using DFS to find if the path exist or not

import java.util.ArrayList;

public class hasPath {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // T.C = 0(V+E)
    static boolean HasPath(ArrayList<Edge>[] graph, int src, int dest, boolean arr[]) {
        if (src == dest) {
            return true;
        }
        arr[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // if (arr[e.dest] == false) {
            // boolean res = HasPath(graph, e.dest, dest, arr);
            // if (res == true) {
            // return true;
            // }
            // }
            if (!arr[e.dest] && HasPath(graph, e.dest, dest, arr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

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
        graph[3].add(new Edge(3, 5, 1));

        // Vertex 4;
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // Vertex 5;
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex 6;
        graph[6].add(new Edge(6, 5, 1));

        // Has path
        int src = 0;
        int des = 5;

        System.out.println(HasPath(graph, src, des, new boolean[v]));
    }
}
