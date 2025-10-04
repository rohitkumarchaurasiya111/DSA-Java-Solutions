public class FloydWarshallAlgorithm {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };

        floydWarshallAlgo(graph);
    }

    public static void floydWarshallAlgo(int graph[][]) {
        //Performing Floyd's Warshall
        for (int selected = 0; selected < graph.length; selected++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if(i==selected || j == selected || i==j){  //The value of selected one remains same and the value of node to it's own node is 0. So, No need to compare
                        continue;
                    }
                    if (graph[i][selected] != INF && graph[selected][j] != INF
                            && graph[i][j] > graph[i][selected] + graph[selected][j]) {
                        graph[i][j] = graph[i][selected] + graph[selected][j];
                    }
                }
            }
        }

        //Printing the Result
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] != INF)
                    System.out.print(graph[i][j] + "   ");
                else 
                    System.out.print("INF ");
            }
        System.out.println();
        }
        
    }
}
