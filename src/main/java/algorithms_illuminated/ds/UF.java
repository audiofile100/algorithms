package algorithms_illuminated.ds;

// common application: determining connected components of undirected graph
// heuristics: union by rank & path compression yields optimal disjoint-set structures
public class UF {

    private final int[] parent;
    private final int[] rank;
    private final int vertices;
    private int count;

    public UF(int vertices) {
        this.vertices = vertices;
        parent = new int[vertices];
        rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
        count = vertices;
    }

    public boolean union(int id1, int id2) {
        int x = find_set(id1);
        int y = find_set(id2);
        if (x == y) return false;
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        if (rank[x] == rank[y]) {
            rank[y]++;
        }
        --count;
        return true;
    }

    private int find_set(int id) {
        if (id != parent[id]) {
            parent[id] = find_set(parent[id]);
        }
        return parent[id];
    }

    public void display() {
        for (int n : parent) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n : rank) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("count: " + count);
    }

    public static void main(String[] args) {

        UF uf = new UF(10);

        System.out.println(uf.union(1, 4));
        uf.display();

        uf.union(2, 1);
        uf.display();

        uf.union(3, 1);
        uf.display();

        uf.union(5, 3);
        uf.display();

        uf.union(9, 8);
        uf.display();

        uf.union(7, 6);
        uf.display();

        uf.union(7, 9);
        uf.display();

        System.out.println(uf.union(7, 9));
        uf.display();

        System.out.println(uf.union(7, 9));
        uf.display();
    }
}
