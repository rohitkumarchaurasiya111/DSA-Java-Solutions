//Find whether it is possible to finish all tasks or not
// There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisites, for example to pick task 0 you have to first pick task 1, which is expressed as a pair: [0, 1].
// Given the total number of tasks and a list of prerequisite pairs, is it possible for you to finish all tasks?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule {
    public static void main(String[] args) {
        // Number of tasks
        int n = 5; 
        int[][] prerequisites = {
            {1, 4},
            {2, 4},
            {3, 1},
            {3, 2}
        };
        System.out.println(canFinish(n, prerequisites));
    }

    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //Here, we need to find out if cycle exists between this graph or not, if cycle exists then return false
    //Since, it is Directed Acyclic Graph -> So, Using Kahn's Algorithm 
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];

        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraphAndCalInDegree(indeg, graph, prerequisites);
        return topologicalSortingUsingBFS(graph, indeg, numCourses);
    }

    //Kahn's Algorithm
    //Calculating InDegree as well as creating graph
    static void createGraphAndCalInDegree(int indeg[], ArrayList<Edge> graph[], int[][] prerequisite){
        for (int i = 0; i < prerequisite.length; i++) {
            int dependent = prerequisite[i][0];
            int required = prerequisite[i][1];
            indeg[dependent]++;
            graph[required].add(new Edge(required, dependent));
        }
    }

    static boolean topologicalSortingUsingBFS(ArrayList<Edge> graph[], int indeg[], int numCourses){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].size() ; i++) {
                Edge currEdge = graph[curr].get(i);
                indeg[currEdge.dest]--;
                if(indeg[currEdge.dest] == 0) q.add(currEdge.dest);
            }
        }

        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] != 0) return false;
        }
        return true;
    }

}
