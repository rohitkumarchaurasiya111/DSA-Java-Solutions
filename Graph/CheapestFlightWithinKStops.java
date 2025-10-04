import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Similar to Dijkstra's Algorithm
class CheapestFlightWithinKStops{
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}} ;
        int src = 0, dst = 3, k = 1 ;

        System.out.println("Cheapest cost is: " + findCheapestcost(n, flights, src, dst, k));
    }

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(int[][] flights, List<Edge> graph[]){
        //Array of ArrayList to store the Graph
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            Edge e = new Edge(src, dest, cost);

            graph[src].add(e);
        }


    }

    public static int findCheapestcost(int n, int[][] flights, int src, int dst, int k) {
        List<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);   //Creating Graph using given information

        int dist[] = new int[n];   //Array to track the minimum distance
        //Initializing all the distance to infinity except the src, dist[src] = 0
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Using Queue 
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(src,0,0));  //Adding the src node to the queue

        while (!queue.isEmpty()) {
            Info curr = queue.remove();

            if(curr.stops > k){
                break;
            }

            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge currEdge = graph[curr.vertex].get(i);
                int srcEdge = currEdge.src;
                int destEdge = currEdge.dest;
                int wtEdge = currEdge.wt;

                if(curr.cost + wtEdge < dist[destEdge]){
                    dist[destEdge] = curr.cost + wtEdge;
                    queue.add(new Info(destEdge,dist[destEdge] ,curr.stops + 1 ));
                }

            }

        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}