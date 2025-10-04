import java.util.ArrayList;

//If some part of the graph is not connected to each other, then the normal traversal will only give us the some part but will not be able to traverse the whole graph. So, we are making some modification to the normal code so that our code can work fine even in the case of disconnected graph

public class DFS_Modified {
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

    static void DFS(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSutil(graph, i, visited);
            }
        }
    }

    static void DFSutil(ArrayList<Edge>[] graph, int curr, boolean arr[]) {
        System.out.print(curr + " ");
        arr[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge temp = graph[curr].get(i);
            if (!arr[temp.dest]) {
                DFSutil(graph, temp.dest, arr);
            }
        }
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

        DFS(graph);
    }
}
