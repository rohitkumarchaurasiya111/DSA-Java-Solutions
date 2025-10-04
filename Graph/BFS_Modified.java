import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//If some part of the graph is not connected to each other, then the normal traversal will only give us the some part but will not be able to traverse the whole graph. So, we are making some modification to the normal code so that our code can work fine even in the case of disconnected graph

public class BFS_Modified {

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

    static void BFS(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                q.add(i);   //If the vertex is not visited then we add them in our queue
                BFSutil(graph, visited, q);
            }
        }
    }

    static void BFSutil(ArrayList<Edge>[] graph, boolean bool[], Queue<Integer> q) {

        while (!q.isEmpty()) {
            int current = q.remove();

            if (bool[current] == false) {
                System.out.print(current + " ");
                bool[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    Edge e = graph[current].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 9;
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
        graph[3].add(new Edge(3, 5, 1));

        // Vertex 4;
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 2, 1));

        // Vertex 5;
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex 6;
        graph[6].add(new Edge(6, 5, 1));


        //These two nodes make the graph disconnected
        graph[7].add(new Edge(7, 8, 1));
        graph[8].add(new Edge(8, 7, 1));

        BFS(graph);

    }
}
