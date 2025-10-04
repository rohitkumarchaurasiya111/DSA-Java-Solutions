import java.util.PriorityQueue;

//We need to get MST - So, We will use prim's Algorithm
public class ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println("Minimum Cost: " + minimumCost(cities));
    }

    // This will store Node and the cost to keep into the priority Queue
    static class Info implements Comparable<Info> {
        int node;
        int cost;

        public Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i2) {
            return this.cost - i2.cost; // PQ will give the nodes in ascending order of their cost
        }
    }

    static int minimumCost(int cities[][]) {
        int totalCost = 0; // This will store the minimum cost
        boolean isVisited[] = new boolean[cities.length];
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0)); // Adding the root node

        while (!pq.isEmpty()) {
            Info currInfo = pq.remove();
            if (isVisited[currInfo.node])
                continue;
            isVisited[currInfo.node] = true;
            totalCost += currInfo.cost;

            for (int i = 0; i < cities[currInfo.node].length; i++) {
                //only add those cities where node has some cost, 0 means there is no edge between them
                if (cities[currInfo.node][i] != 0) {
                    Info newInfo = new Info(i, cities[currInfo.node][i]);
                    if (!isVisited[newInfo.node])  //If already visited no need to add them
                        pq.add(newInfo);
                }
            }
        }
        return totalCost;
    }
}
