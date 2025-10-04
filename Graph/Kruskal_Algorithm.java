import java.util.ArrayList;
import java.util.Collections;

/*
 * Steps:
 * 1. Store all the Edges in a List
 * 2. Sort the edges on the basis of cost (low to high)
 * 3. Get the edge and see if it forms loop or not - to track this we can use Disjoint set union
 * 4. if loop doesnot form - add in MST
 */
public class Kruskal_Algorithm {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int cost;

        public Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge obj) {
            return this.cost - obj.cost;
        }

    }

    // Disjoint Set Union DS
    // Implementing Disjoint Set Union DS - to see that loop doesnot occurs
    static int parent[], rank[];

    static void init(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    // This function finds the parent of a node
    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    // This function we will use to see if loop occurs or not
    static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (rank[parX] == rank[parY]) {
            parent[parY] = parX;
            rank[parX]++;
        } else if (rank[parX] > rank[parY])
            parent[parY] = parX;
        else
            parent[parX] = parY;
    }

    // Finding MST using Disjoint Set DS
    public static int findMST(ArrayList<Edge> graph, int V) {
        Collections.sort(graph);
        int minCost = 0;
        int edgeCount = 0;
        for (int i = 0; edgeCount < V-1 ; i++) {  //in MST, edge = no. of Vertices - 1;
            Edge curr = graph.get(i);
            int parSrc = find(curr.src);
            int parDest = find(curr.dest);
            if(parSrc != parDest){
                union(curr.src, curr.dest);
                minCost += curr.cost;
                edgeCount++;
            }
        }
        return minCost;
    }

    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    public static void main(String[] args) {
        int V = 4;
        init(V);
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        System.out.println(findMST(graph, V));
    }

}
