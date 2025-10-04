public class UnionFind {

    static int rank[], parent[];

    public static void init(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (parent[x - 1] == parent[y - 1]) {
                return new int[] { x, y };
            }
            union(x - 1, y - 1);
        }
        return new int[] { -1, -1 };
    }

    public static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (rank[parX] == rank[parY]) {
            parent[parY] = parX;
            rank[parX]++;
        } else if (rank[parX] > rank[parY]) {
            parent[parY] = parX;
        } else {
            parent[parX] = parY;
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        // int[][] edges = {
        //     {1, 2},
        //     {2, 3},
        //     {3, 4},
        //     {1, 4},
        //     {1, 5}
        // };
        int[][] edges = {
            {3, 4},
            {1, 2},
            {2, 4},
            {3, 5},
            {2, 5}
        };
        int ans[] = findRedundantConnection(edges);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
