package ds.uf;

public class UF {

    private final int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;

        id[pid] = qid;
        --count;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];   // follows links to find root: O(n)
        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
