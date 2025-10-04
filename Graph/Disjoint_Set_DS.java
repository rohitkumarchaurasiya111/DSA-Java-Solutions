
public class Disjoint_Set_DS {
    static int n = 8;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (rank[parentX] == rank[parentY]) {
            parent[parentY] = parentX;
        } else if (rank[parentX] > rank[parentY])
            parent[parentY] = parentX;
        else
            parent[parentX] = parentY;
    }
}
