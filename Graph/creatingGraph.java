
import java.util.ArrayList;
import java.util.Scanner;

public class creatingGraph {
    // To stores the Vertices we make a class Edge
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void main(String[] args) {
        int v = 5; // No. of Vertices
        ArrayList<Edge>[] graph = new ArrayList[v];

        // At Each Index of Graph Array We initialize an Empty ArrayList to store the
        // edges
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // For Vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // For Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // For Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // For Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // For Vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // Neighbours of index
        Scanner sc = new Scanner(System.in);
        System.out.print("Find Neighbour of Vertex: ");
        int ver = sc.nextInt();

        System.out.print("Edge " + ver + " Neighbours are: ");
        for (int i = 0; i < graph[ver].size(); i++) {
            Edge temp = graph[ver].get(i);
            System.out.print(temp.dest + " ");
        }
        sc.close();
    }
}
