import java.util.ArrayList;

//Tarjan's Algorithm


public class Articulation_Point_Tarjan_Algorithm {
    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Edge list: each edge as [u, v]
        int[][] edges = {
            {0, 1},
            {1, 4},
            {4, 3},
            {4, 2},
            {2, 3}
        };

        // Call articulation points method
        ArrayList<Integer> articulationPoints = articulationPoints(V, edges);

        System.out.println("Articulation Points: " + articulationPoints);
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        //Creating Adjacency List for this given edges
        ArrayList<Integer> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(dest);
            graph[dest].add(src);
        }

        int dt[] = new int[V];              //Discovery Time
        int low[] = new int[V];             //Lowest Discovery Time of neighbours and current nodes
        int time = 0;
        boolean visited[] = new boolean[V];                 //To track visited Nodes, Prevents loop
        ArrayList<Integer> answer = new ArrayList<>();      //To store the articulation points

        for (int i = 0; i < V; i++) {
            if(!visited[i])
                dfs(graph, i, -1, 0, dt, low, visited, time, answer);
        }
        if(answer.size() == 0)
            answer.add(-1);
        return answer;
    }

    static void dfs(ArrayList<Integer> graph[], int curr, int parent, int noOfChilderns, int dt[], int low[], boolean visited[], int time, ArrayList<Integer> answer){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbourNode = graph[curr].get(i);

            // Different Cases:
            if(neighbourNode == parent) continue;           //If neighbourNode is parent - Ignore
            else if(!visited[neighbourNode]){               //If neighbourNode is notVisited then it is my children
                dfs(graph, neighbourNode, curr, 0, dt, low, visited, time, answer);
                noOfChilderns++;
                low[curr] = Math.min(low[curr], low[neighbourNode]);
                if(parent != -1 && dt[curr] <= low[neighbourNode])    //Condition for Articulation Point - Case 2 and 3
                    if(!answer.contains(curr))
                        answer.add(curr);
            }else{                                          //If neighbourNode is visited and not my parent
                low[curr] = Math.min(low[curr], dt[neighbourNode]);
            }   
        }
        if(parent == -1 && noOfChilderns > 1){              //Condition for Articulation Point - Case 1
            answer.add(curr);
        }

    }
}
