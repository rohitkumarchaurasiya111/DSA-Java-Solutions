import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Using Tarjan's Algorithm - To get bridges in Graph
//Use two array - 1. Discovery Time , 2. Lowest Time of Neighbours and me
//call DFS with 3 conditions
// 1. neighbour = parent  do nothing
// 2. Neighbour is not visited then call dfs(neighbour) and update low of current after returning and check bridge condition if(dt[curr]<low[neighbour])
// 3. Neighbour is visited but not my parent then update low of curr

public class Bridge_in_Graph {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        List<List<Integer>> bridges = criticalConnections(n, connections);

        System.out.println("Critical Connections: " + bridges);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //Creating Graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        createGraph(connections, graph);

        //We use two Arrays
        int dt[] = new int[n]; // Stores Discovery Time
        int low[] = new int[n]; //Stores lowest Discovery Time of neighbours and current node
       
        boolean visited[] = new boolean[n]; //Used in DFS
        int time = 0; //To update discovery time

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {  //This loop ensures all nodes are visited even if they are not connected
            if(!visited[i])
                dfs(graph, -1, visited, 0, dt, low, time, answer);
        }
        return answer;
    }

    //This function creates graph in a form of Adjacency List
    public static void createGraph(List<List<Integer>> connections, ArrayList<ArrayList<Integer>> graph){
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            int src = edge.get(0);
            int dest = edge.get(1);
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> connections, int parent, boolean visited[], int currNode, int dt[], int low[], int time, List<List<Integer>> answer){
        visited[currNode] = true;
        //Initially low = discovery time,
        dt[currNode] = low[currNode] =  ++time;

        for (int i = 0; i < connections.get(currNode).size(); i++) {
            int neighbourNode = connections.get(currNode).get(i);
            if(neighbourNode == parent) continue;                          //1. Neighbour Node is Parent - Ignore
            else if(!visited[neighbourNode]){                              //2. Neighbour Node is Not Visited
                dfs(connections, currNode, visited, neighbourNode, dt, low, time,answer);
                low[currNode] = Math.min(low[currNode], low[neighbourNode]);   //Update low of current after returning from Neighbour
                if(dt[currNode] < low[neighbourNode]){                         //Bridge Forms
                    answer.add(Arrays.asList(currNode,neighbourNode)); 
                    System.out.println(currNode + " -> " + neighbourNode);
                }
            }
            else if(visited[neighbourNode] && neighbourNode!=parent){      //3. Neighbour Node is Visited but Not Parent

                low[currNode] = Math.min(low[currNode], dt[neighbourNode]);
            }
        }
    }
}
